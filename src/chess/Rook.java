package chess;

import static chess.Constants.ACTIVE;
import static chess.Constants.INACTIVE;

public class Rook extends Movable implements Piece {
    /**
     * Initializes a new piece by setting the position, setting the color and
     * setting the state. A piece is active until it is killed by the
     * other player.
     * @param x   location on board
     * @param y   location on board
     * @param clr of piece (white or black)
     */
    public Rook(final int x, final int y, final int clr) {
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

             /* Calculate the distances between selected destination and current position. */
            int disX = (x - getPosX());
            int disY = (y - getPosY());

            int i = getPosX();
            int j = getPosY();

            Board board = Board.getBoard();

            /* Move right across board. */
            if (disY == 0 && disX > 0) {
                for (; i < x; ++i) {
                    if (!board.isEmpty(i + 1, y) && i + 1 != x) {
                        return false;
                    }
                }
            /* Move left across board. */
            } else if (disY == 0 && disX < 0) {
                for (; i > x; --i) {
                    if (!board.isEmpty(i - 1, y) && i - 1 != x) {
                        return false;
                    }
                }
            /* Move down across board. */
            } else if (disX == 0 && disY > 0) {
                for (; j < y; ++j) {
                    if (!board.isEmpty(x, j + 1) && j + 1 != y) {
                        return false;
                    }
                }
            /* Move up across board. */
            } else if (disX == 0 && disY < 0) {
                for (; j > y; --j) {
                    if (!board.isEmpty(x, j - 1) && j - 1 != y) {
                        return false;
                    }
                }
            }
            /*
             * If selected location contains another
             * piece in the same color, move is invalid.
             */
            if (board.getColorAt(x, y) == getColor()) {
                return false;
            }

            /*
             * If selected location contains a piece in
             * the opposite color, then that piece is killed.
             */
            if (board.getColorAt(x, y) != getColor() && !board.isEmpty(x, y) && (disX == 0 || disY == 0)) {
                //board.getPiece(x, y).kill();
                System.out.println("rook attach");
                return true;
            } else if (Board.getBoard().isEmpty(x, y) && (disX == 0 || disY == 0)) {
                return true;
            }
        }
    return false;
}

    /**
     * Makes the move and a piece if one is being captured.
     * @param x
     * @param y
     * @return captured that is being captured
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
