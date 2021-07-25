package chess;

import static chess.Constants.ACTIVE;
import static chess.Constants.INACTIVE;

public class Knight extends Movable implements Piece {
    /**
     * Initializes a new piece by setting the position,
     * setting the color and setting the state.
     * A piece is active until it is killed by the other player
     * @param x location on board
     * @param y location on board
     * @param clr of piece (white or black)
     */
    public Knight(final int x, final int y, final int clr) {
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
             * selected destination
             * and current position.
             */
            int disX = Math.abs(x - getPosX());
            int disY = Math.abs(y - getPosY());

            if ((disX == 1 && disY == 2)
                    || (disX == 2 && disY == 1)) {
                if (Board.getBoard().isEmpty(x, y)) {
                    Board.getBoard().togleTurn();
                    return true;
                } else if (!Board.getBoard().isEmpty(x, y)
                        && Board.getBoard().
                        getColorAt(x, y)
                        != getColor()) {

                    Board.getBoard().getPiece(x, y).kill();
                    Board.getBoard().togleTurn();
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
                this.getPosX(),
                this.getPosY());
        setPos(x, y);
        Board.getBoard().setPiece(this);
    }

    /**
     * @return name of piece
     */
    public String getName() {
        return "KNIGHT";
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
