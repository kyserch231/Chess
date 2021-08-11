package chess;

import static chess.Constants.BLACK;
import static chess.Constants.ACTIVE;

public class Movable {

    /** Location of piece. */
    private Location position = new Location();

    /** True if active, otherwise false. */
    private boolean state;

    /** Black or white. */
    private int color;

    /**
     * @return true if color of piece is black, otherwise false
     */
    public boolean isBlack() {
        return (color == BLACK);
    }

    /**
     * @return color of piece
     */
    public int getColor() {
        return color;
    }

    /**
     * Sets color of piece.
     * @param clr
     */
    public void setColor(final int clr) {
        color =  clr;
    }

    /**
     * Sets position on x and y.
     * @param x
     * @param y
     */
    public void setPos(final int x, final int y) {
        position.setPosition(x, y);
    }

    /**
     * @return location of piece
     */
    public Location getLoc() {
        return  position;
    }

    /**
     * @return x-value of current location
     */
    public int getPosX() {
        return position.getPosX();
    }

    /**
     * @return y-value of current location
     */
    public int getPosY() {
        return position.getPosY();
    }

    /**
     * Sets state to a.
     * @param a
     */
    public void setState(final boolean a) {
        state = a;
    }
    
    /**
     * @return current state
     */
    public boolean getState() {
    	return state;
    }
    
    public boolean isActive() {
    	return ACTIVE;
    }
}
