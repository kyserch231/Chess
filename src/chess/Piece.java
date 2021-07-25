package chess;

public interface Piece {

    /**
      * Check to see if the move is valid.
     * @param x
     * @param y
     * @return true is move is valid and false if it is not
     */
    boolean isValidMove(int x, int y);

    /**
     * Makes the move and returns true if success , otherwise false.
     * @param xMove
     * @param yMove
     */
    void move(int xMove, int yMove);

    /**
     * @return name of piece
     */
    String getName();

    /**
     * When a piece is killed by the opposite player,
     * the piece will become inactive.
     */
    void kill();

    /**
     * @return current location of piece
     */
    Location getLoc();

    /**
     * @return true if the color of the piece is black
     * and false if it is white.
     */
    boolean isBlack();

    /**
     * @return color of piece
     */
    int getColor();

}


