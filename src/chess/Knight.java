package chess;

public class Knight extends Movable implements Constants, Piece {

	public Knight (int x, int y, int clr) {
		position.setPosition(x,y);
		color = clr;
		state = ACTIVE;
	}
	
	@Override
	public boolean isValidMove(int x, int y) {
		
		// calculate the distances b/w selected destination and current position
		int disX = Math.abs(x - position.getPositionX());
		int disY = Math.abs(y - position.getPositionY());
			
		System.out.println(disX + ", " + disY);
				
		if ((disX == 1 && disY == 2) || (disX == 2 && disY == 1)) {
			if (Board.getBoard().isEmpty(x, y))
				return true;
			
			else if (!Board.getBoard().isEmpty(x, y) && Board.getBoard().getColorAt(x, y) != color) {
				Board.getBoard().getPiece(x, y).kill();
				return true;
			}
		}
		
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
		return "KNIGHT";
	}

	@Override
	public void kill() {
		state = INACTIVE;
	}

}
