package chess;

import static chess.Constants.ACTIVE;
import static chess.Constants.INACTIVE;
import static chess.Constants.BLACK;
import static chess.Constants.WHITE;

public class Bishop extends Movable implements Piece {
    /**
     * Initializes a new piece by setting the position,
     * setting the color and setting the state.
     * A piece is active until it is killed by the other player
     * @param x location on board
     * @param y location on board
     * @param clr of piece (white or black)
     */
    public Bishop(final int x, final int y, final int clr) {
        setPos(x, y);
        setColor(clr);
        setState(ACTIVE);
    }

    /**
     * Check to see if the move is valid.
     * @param x
     * @param y
     * @return true is move is valid and false if it is not
     */
    public boolean isValidMove(final int x, final int y) {
        if (this.isActive()) {
            /*
             * Calculate the distances between
             * selected destination and current position.
             */
            int disX = (x - getPosX());
            int disY = (y - getPosY());

            /*
             * Determines if there are any pieces in the way between
             * selected square and current square,
             * move in invalid if there are any pieces.
             */
            if (Math.abs(disY) == Math.abs(disX)) {
                int i = getPosX();
                int j = getPosY();
                Board board = Board.getBoard();

                if (disX > 0 && disY > 0) {
                    // if selected square is to bottom right
                    for (; i < x; ++i, ++j) {
                        if (!board.isEmpty(i + 1, j + 1) && i + 1 != x && j + 1 != y) {
                            return false;
                        }
                    }
                } else if (disX < 0 && disY > 0) {
                    // if selected square is to bottom left
                    for (; i > x; --i, ++j) {
                        if (!board.isEmpty(i - 1, j + 1) && i - 1 != x && j + 1 != y) {
                            return false;
                        }
                    }
                } else if (disX > 0 && disY < 0) {
                    // if selected square is to top right
                    for (; i < x; ++i, --j) {
                        if (!board.isEmpty(i + 1, j - 1) && i + 1 != x && j - 1 != y) {
                            return false;
                        }
                    }
                } else if (disX < 0 && disY < 0) {
                    // if selected square is to top left
                    for (; i > x; --i, --j) {
                        if (!board.isEmpty(i - 1, j - 1) && i - 1 != x && j - 1 != y) {
                            return false;
                        }
                    }
                }

                /* If selected location contains another piece in the same color, move is invalid. */
                if (board.getColorAt(x, y) == getColor()) {
                    return false;
                }

                /* If selected location contains a piece in the opposite color, then that piece is killed. */
                if (board.getColorAt(x, y) != getColor() && !board.isEmpty(x, y)) {
                    //board.getPiece(x, y).kill();
                    System.out.println("bishop attach");
                    return true;
                } else if (board.isEmpty(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Makes the move and a piece if one is being captured.
     * @param x
     * @param y
     * @return piece that is being captured
     */
    public Piece move(final int x, final int y) {

        Piece captured = null;
        
        if (!Board.getBoard().isEmpty(x, y)) {
            captured = Board.getBoard().getPiece(x, y);
            Board.getBoard().getPiece(x, y).capture();
        }

        Board.getBoard().setToEmpty(this.getPosX(), this.getPosY());
        setPos(x, y);
        Board.getBoard().setPiece(this);

        return captured;
    }

    /**
     * When a piece is killed by the opposite player,
     * the piece will become inactive.
     */
    public void capture() {
        setState(INACTIVE);
    }

    /**
     * @param x location of opposite king
     * @param y location of opposite king
     * @return true if the piece has check on the opposite king
     */
	public boolean hasCheck(int x, int y) {
		if (getState() == INACTIVE) {
			return false;
		} else if (this.isValidMove(x, y)) {
			return true;
		}
		return false;
	}
}
