package chess;

import static chess.Constants.BLACK;
import static chess.Constants.WHITE;
import static chess.Constants.ACTIVE;
import static chess.Constants.INACTIVE;

public class Pawn extends Movable implements Piece {

    /** Used to determine is the piece have taken its first move. */
    private boolean hasMoved;

    /**
     * Initializes a new piece by setting the position,
     * setting the color, setting the state and a variable
     * to determine is the piece has taken its first move.
     * A piece is active until it is killed by the other player
     * @param x location on board
     * @param y location on board
     * @param clr of piece (white or black)
     */
    public Pawn(final int x, final int y, final int clr) {
        setPos(x, y);
        setColor(clr);
        setState(ACTIVE);
        hasMoved = false;
    }

    /**
     * Check to see if the move is valid.
     * @param x
     * @param y
     * @return true is move is valid and false if it is not
     */
    public boolean isValidMove(final int x, final int y) {
        /*
         * Calculate the distances between
         * selected destination
         * and current position.
         */
        int disX = (x - getPosX());
        int disY = (y - getPosY());

        Board board = Board.getBoard();

        if (board.getTurn() == getColor()) {

            /*
             * Pawn can move two spaces up on first move,
             * one space up, and one space
             * diagonally to attach
             */
            if (getColor() == BLACK) {
                if (board.isEmpty(x, y) && disX == 0) {
                    if (hasMoved && disY == 1) {
                        board.togleTurn();
                        return true;
                    } else if (!hasMoved && disY == 2 || disY == 1) {
                        board.togleTurn();
                        return true;
                    }
                } else if (disY == 1 && Math.abs(disX) == 1 && board.getColorAt(x, y) != getColor()) {
                    board.getPiece(x, y).kill();
                    board.togleTurn();
                    return true;
                }
            } else if (getColor() == WHITE) {
                if (board.isEmpty(x, y) && disX == 0) {
                    if (hasMoved && disY == -1) {
                        board.togleTurn();
                        return true;
                    } else if (!hasMoved && disY == 2 * -1 || disY == -1) {
                        board.togleTurn();
                        return true;
                    }
                } else if (disY == -1 && Math.abs(disX) == 1 && board.getColorAt(x, y) != getColor()) {
                    board.getPiece(x, y).kill();
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
        Board.getBoard().setToEmpty(this.getPosX(), this.getPosY());
        setPos(x, y);
        Board.getBoard().setPiece(this);
        hasMoved = true;
    }

    /**
     * When a piece is killed by the opposite player,
     * the piece will become inactive.
     */
    public void kill() {
        setState(INACTIVE);
    }
}
