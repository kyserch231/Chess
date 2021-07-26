package chess;

public class Location {

    /**
     * Initializes location.
     */
    public Location() { }

    /** Position x of location. */
    private int positionX;
    /** Position y of location. */
    private int positionY;

    /**
     * @return position x of location.
     */
    int getPosX() {
        return positionX;
    }

    /**
     * @return position y of location.
     */
    int getPosY() {
        return positionY;
    }

    /**
     * Sets location given a x and y location.
     * @param x
     * @param y
     */
    void setPosition(final int x, final int y) {
        positionX = x;
        positionY = y;
    }
}
