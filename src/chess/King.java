package chess;

<<<<<<< HEAD
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class King extends Movable implements Constants, Piece {
=======
import static chess.Constants.ACTIVE;
import static chess.Constants.INACTIVE;
>>>>>>> 67ff0f24b8d88d0834eb3b1247088c6e99800d3e

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

        if (Board.getBoard().getTurn() == getColor()) {
            /*
             * Calculate the distances
             * between selected destination
             * and current position.
             */
            int disX = Math.abs(x - getPosX());
            int disY = Math.abs(y - getPosY());

            // king can move one space up, back, or diagonally
            if ((disX == 1 && disY == 0)
                    || (disX == 0 && disY == 1)
                    || (disX == 1 && disY == 1)) {
                /*
                 * If selected location contains
                 * another piece in the same color,
                 * move is invalid.
                 */
                if (Board.getBoard().
                        getColorAt(x, y)
                        == getColor()) {
                    return false;
                }
                /*
                 * If selected location contains a piece in the
                 * opposite color, then that piece is killed.
                 */
                if (Board.getBoard().getColorAt(x, y)
                        != getColor()
                        && !Board.getBoard().
                        isEmpty(x, y)) {
                    Board.getBoard().getPiece(x, y).kill();
                    Board.getBoard().togleTurn();
                    return true;
                } else if (Board.getBoard().isEmpty(x, y)) {
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
        return " KING ";
    }

<<<<<<< HEAD
	@Override
	public void kill() {
		
		// pop up of who won
		state = INACTIVE;
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		JOptionPane.showMessageDialog(frame, "You have won, use the file tab to play again!");

		
	}
=======
    /**
     * When a piece is killed by the opposite player,
     * the piece will become inactive.
     */
    public void kill() {
        // pop up of who won
        setState(INACTIVE);
    }

    /**
     * @return location of piece
     */
    public Location getLoc() {
        return getLoc();
    }
>>>>>>> 67ff0f24b8d88d0834eb3b1247088c6e99800d3e

}
