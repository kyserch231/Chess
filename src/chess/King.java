package chess;

public class King extends Movable implements Constants, Piece {

	public King(int x, int y, int clr) {
		position.setPosition(x,y);
		color = clr;
		state = ACTIVE;
	}
	

	public boolean isValidMove(int x, int y) {
		
		// calculate the distances b/w selected destination and current position
		int disX = Math.abs(x - position.getPositionX());
		int disY = Math.abs(y - position.getPositionY());
		
		// king can move one space up, back, or diagonally
		
		if (disX == 1 && disY == 0)
			return true;
		
		if (disX == 0 && disY == 1)
			return true;
		
		if (disX == 1 && disY == 1)
			return true;
		
		return false;
	}

	@Override
	public void move(int x, int y) {
		Board.getBoard().setToEmpty(this.getLocation().getPositionX(), this.getLocation().getPositionY());
		position.setPosition(x,y);
		Board.getBoard().setPiece(this);
	}


	@Override
	public String getName() {
		return " KING ";
	}


	@Override
	public void kill() {
		// TODO Auto-generated method stub
		
	}

}
