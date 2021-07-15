package chess;

public interface Piece {
	/*
	 * check to see if the move is valid
	 * */
	boolean isValidMove(int x, int y);
	
	/*
	 * makes the move and returns true if success , otherwise false
	 * */
	void move(int xMove, int yMove);
	
	
	/*
	 *	Active or not 
	 * */
	boolean isActive();
	
	/*
	 *	Black or not 
	 * */
	boolean isBlack();
	
	/*
	 *	White or not 
	 * */
	boolean isWhite();
	
	
	/*
	 * 
	 */
	
	public Location getLocation();
	
	public int getColor();
	
	public void setState(boolean a);
	
	public void kill();
	
	public String getName();
}
