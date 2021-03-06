package chess;

import static chess.Constants.ACTIVE;
import static chess.Constants.BLACK;
import static chess.Constants.INACTIVE;

public class King extends Movable implements Piece {
    /**
     * Initializes a new piece by setting the position,
     * setting the color and setting the state.
     * A piece is active until it is killed by the other player
     * @param x location on board
     * @param y location on board
     * @param clr of piece (white or black)
     */
    public King(final int x, final int y, final int clr) {
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
             * Calculate the distances
             * between selected destination
             * and current position.
             */
            int disX = Math.abs(x - getPosX());
            int disY = Math.abs(y - getPosY());

            // king can move one space up, back, or diagonally
            if ((disX == 1 && disY == 0) || (disX == 0 && disY == 1) || (disX == 1 && disY == 1)) {

            	/* If selected location is checked by a piece in the opposite color, move is invalid. */
            	if (moveIsChecked(x, y)) {
            		return false;
            	}
            	
                /* If selected location contains another piece in the same color, move is invalid. */
                if (Board.getBoard().getColorAt(x, y) == getColor()) {
                    return false;
                }
                /* If selected location contains a piece in the opposite color, then that piece is killed. */
                if (Board.getBoard().getColorAt(x, y) != getColor() && !Board.getBoard().isEmpty(x, y)) {
                    //Board.getBoard().getPiece(x, y).kill();
                    return true;
                } else if (Board.getBoard().isEmpty(x, y)) {
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
        // pop up of who won
        setState(INACTIVE);
//        int restart =  JOptionPane.showConfirmDialog(null,
//                "Do you want to restart?", "You Win!", JOptionPane.YES_NO_OPTION);
//
//          if (restart == JOptionPane.YES_OPTION) {
//        	  ChessGUI.resetBoard();
//          } else if (restart == JOptionPane.NO_OPTION) {
//        	  System.exit(1);
//          }
    }
    
    /**
     * @param x location king is to move to
     * @param y location king is to move to
     * @return true if move is going to put king in check
     */
 	public boolean moveIsChecked(int x, int y) {
 		
 		if (this.getColor() == BLACK) {

 			for (int i = 0; i < Board.getWhitePieces().size(); i++) {
 				if (Board.getWhitePieces().get(i).hasCheck(x, y)) {
 					return true;
 				}
 			}
 			return false;
 		} else {
 			
 			for (int i = 0; i < Board.getBlackPieces().size(); i++) {
 				if (Board.getBlackPieces().get(i).hasCheck(x, y)) {
 					return true;
 				}
 			}
 			return false;			
 		}
 	}
    /**
     * @param x location of opposite king
     * @param y location of opposite king
     * @return true if the piece has check on the opposite king
     */
	public boolean hasCheck(final int x, final int y) {
		if (getState() == INACTIVE) {
			return false;
		} else if (this.isValidMove(x, y)) {
			return true;
		}
		return false;
	}
}
