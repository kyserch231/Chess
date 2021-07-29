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
     * Makes the move and a piece if one is being captured.
     * @param x
     * @param y
     * @return captured that is being captured
     */
    Piece move(int x, int y);

    /**
     * When a piece is killed by the opposite player,
     * the piece will become inactive.
     */
    void capture();

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
    
    /**
     * @return true is piece is active
     */
    boolean isActive();
    
    /**
     * @param x location of opposite king
     * @param y location of opposite king
     * @return true if the piece has check on the opposite king
     */
    boolean hasCheck(int x, int y);
}


