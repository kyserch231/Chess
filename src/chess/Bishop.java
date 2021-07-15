package chess;

public class Bishop extends Movable implements Constants, Piece {
	
	public Bishop(int x, int y, int clr) {
		position.setPosition(x,y);
		color = clr;
		state = ACTIVE;
	}

	@Override
	public boolean isValidMove(int x, int y) {
		// TODO Auto-generated method stub
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
		return "BISHOP";
	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub
		
	}

}
