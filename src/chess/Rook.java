package chess;

public class Rook extends Movable implements Constants, Piece {
	
	public Rook(int x, int y, int clr) {
		position.setPosition(x,y);
		color = clr;
		state = ACTIVE;
	}

	@Override
	public boolean isValidMove(int x, int y) {
		
		// calculate the distances b/w selected destination and current position
//		int disX = (x - position.getPositionX());
//		int disY = (y - position.getPositionY());
		
		if (x > position.getPositionX() && y == position.getPositionY()) {
			for (int i = position.getPositionX(); i < x; ++i) {
				if (!Board.getBoard().isEmpty(i, y))
					return false;
			}
		} else if (x < position.getPositionX() && y == position.getPositionY()) {
			for (int i = x; i < position.getPositionX(); ++i) {
				if (!Board.getBoard().isEmpty(i, y))
					return false;
			}
		} else if (y > position.getPositionY() && x == position.getPositionX()) {
			for (int i = position.getPositionY(); i < y; ++i) {
				if (!Board.getBoard().isEmpty(x, i))
					return false;
			}
		} else if (y < position.getPositionY() && x == position.getPositionX()) {
			for (int i = y; i < position.getPositionY(); ++i) {
				if (!Board.getBoard().isEmpty(x, i))
					return false;
			}
		}
		
		if (Board.getBoard().getColorAt(x, y) == color)
			return false;
		
		return true;
	}

	@Override
	public void move(int x, int y) {
		Board.getBoard().setToEmpty(this.getLocation().getPositionX(), this.getLocation().getPositionY());
		position.setPosition(x,y);
		Board.getBoard().setPiece(this);
	}

	@Override
	public String getName() {
		return " ROOK ";
	}

	@Override
	public void kill() {
		state = INACTIVE;
	}

}
