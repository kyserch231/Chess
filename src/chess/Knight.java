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

        if (this.isActive()) {

            /*
             * Calculate the distances between
             * selected destination
             * and current position.
             */
            int disX = Math.abs(x - getPosX());
            int disY = Math.abs(y - getPosY());

            if ((disX == 1 && disY == 2) || (disX == 2 && disY == 1)) {
                if (Board.getBoard().isEmpty(x, y)) {
                    return true;
                } else if (!Board.getBoard().isEmpty(x, y) && Board.getBoard().getColorAt(x, y) != getColor()) {
                    //Board.getBoard().getPiece(x, y).kill();
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
     * @return captured that is being captured
     */
    public Piece move(final int x, final int y) {

        Piece captured = null;

        if (!Board.getBoard().isEmpty(x, y)) {
            captured = Board.getBoard().getPiece(x, y);
            Board.getBoard().getPiece(x, y).capture();
        }

        Board.getBoard();
        Board.setToEmpty(this.getPosX(), this.getPosY());
        setPos(x, y);
        Board.getBoard();
        Board.setPiece(this);

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
