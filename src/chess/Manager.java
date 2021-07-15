package chess;

public interface Manager {

	public void initializePieces();
	
	public void initializeBoard();
	
	public boolean isEmpty(int x, int y);
	
	public int getColorAt(int x, int y);
}
