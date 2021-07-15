package chess;

public class Queen extends Movable implements Constants, Piece {

	public Queen (int x, int y, int clr) {
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
		return " QUEEN";
	}

	@Override
	public void kill() {
		state = INACTIVE;
		
	}

}
