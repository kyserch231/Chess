package chess;

import static chess.Constants.ACTIVE;
import static chess.Constants.INACTIVE;

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
        if (Board.getBoard().getTurn() == getColor()) {
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
                        if (!board.isEmpty(i + 1, j + 1)
                                && i + 1 != x
                                && j + 1 != y) {
                            return false;
                        }
                    }
                } else if (disX < 0 && disY > 0) {
                    // if selected square is to bottom left
                    for (; i > x; --i, ++j) {
                        if (!board.isEmpty(i - 1, j + 1)
                                && i - 1 != x
                                && j + 1 != y) {
                            return false;
                        }
                    }
                } else if (disX > 0 && disY < 0) {
                    // if selected square is to top right
                    for (; i < x; ++i, --j) {
                        if (!board.isEmpty(i + 1, j - 1)
                                && i + 1 != x
                                && j - 1 != y) {
                            return false;
                        }
                    }
                } else if (disX < 0 && disY < 0) {
                    // if selected square is to top left
                    for (; i > x; --i, --j) {
                        if (!board.isEmpty(i - 1, j - 1)
                                && i - 1 != x
                                && j - 1 != y) {
                            return false;
                        }
                    }
                }

                /*
                 * If selected location contains another piece
                 * in the same color, move is invalid.
                 */
                if (board.getColorAt(x, y) == getColor()) {
                    board.togleTurn();
                    return false;
                }

                /*
                 * If selected location contains a piece in the
                 * opposite color, then that piece is killed.
                 */
                if (board.getColorAt(x, y) != getColor()
                        && !board.isEmpty(x, y)) {
                    board.getPiece(x, y).kill();
                    System.out.println("bishop attach");
                    board.togleTurn();
                    return true;
                } else if (board.isEmpty(x, y)) {
                    board.togleTurn();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Makes the move and returns true if success , otherwise false.
     * @param x
     * @param y
     */
    public void move(final int x, final int y) {
        Board.getBoard().setToEmpty(
                getPosX(),
                getPosY());
        setPos(x, y);
        Board.getBoard().setPiece(this);
    }

    /**
     * @return name of piece
     */
    public String getName() {
        return "BISHOP";
    }

    /**
     * When a piece is killed by the opposite player,
     * the piece will become inactive.
     */
    public void kill() {
        setState(INACTIVE);
    }

    /**
     * @return location of piece
     */
    public Location getLoc() {
        return getLoc();
    }

}
