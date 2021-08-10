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

        if (this.isActive()) {

            /*
             * Pawn can move two spaces up on first move,
             * one space up, and one space
             * diagonally to attach
             */
            if (getColor() == BLACK) {
                if (board.isEmpty(x, y) && disX == 0) {
                    if (hasMoved && disY == 1) {
                        return true;
                    } else if (!hasMoved && disY == 2 || disY == 1) {
                        return true;
                    }
                } else if (disY == 1 && Math.abs(disX) == 1 && board.getColorAt(x, y) != getColor() && !board.isEmpty(x, y)) {
                    return true;
                }
            } else if (getColor() == WHITE) {
                if (board.isEmpty(x, y) && disX == 0) {
                    if (hasMoved && disY == -1) {
                        return true;
                    } else if (!hasMoved && disY == 2 * -1 || disY == -1) {
                        return true;
                    }
                } else if (disY == -1 && Math.abs(disX) == 1 && board.getColorAt(x, y) != getColor() && !board.isEmpty(x, y)) {
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
        hasMoved = true;

        if (this.getPosY() == 0 || this.getPosY() == 7) {
        	System.out.println("PAWN PROMOTION");
        }
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
