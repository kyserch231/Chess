package chess;

public class Queen extends Movable implements Constants, Piece {

	public Queen (int x, int y, int clr) {
		position.setPosition(x,y);
		color = clr;
		state = ACTIVE;
	}
	
	@Override
	public boolean isValidMove(int x, int y) {
		

		// calculate the distances b/w selected destination and current position
		int disX = (x - position.getPositionX());
		int disY = (y - position.getPositionY());
		
		// determines if there are any pieces in the way between selected square and current square,
		// move in invalid if there are any pieces
		if (Math.abs(disY) == Math.abs(disX)) {
			
			int i = position.getPositionX(); int j = position.getPositionY();
			
			// if the selected square is to the bottom right
			if (disX > 0 && disY > 0) {
				for (i = position.getPositionX(); i < x; ++i, ++j)
					if (!Board.getBoard().isEmpty(i+1, j+1) && i+1 != x && j+1 != j)
						return false;
			}
			// if the selected square is to the bottom left
			else if (disX < 0 && disY > 0) {
				for (i = position.getPositionX(); i < x; --i, ++j)
					if (!Board.getBoard().isEmpty(i-1, j+1) && i-1 != x && j+1 != j)
						return false;
			}
			
			// if the selected square is to the top right
			else if (disX > 0 && disY < 0) {
				for (i = position.getPositionX(); i < x; ++i, --j)
					if (!Board.getBoard().isEmpty(i+1, j-1) && i+1 != x && j-1 != j)
						return false;
			}
			
			// if the selected square is to the top left
			else if (disX < 0 && disY < 0) {
				for (i = position.getPositionX(); i < x; --i, --j)
					if (!Board.getBoard().isEmpty(i-1, j-1) && i-1 != x && j-1 != j)
						return false;
			}
		
			// if selected location contains another piece in the same color, move is invalid
			if (Board.getBoard().getColorAt(x, y) == color)
				return false;
			
			// if selected location contains a piece in the opposite color, then that piece is killed
			if (Board.getBoard().getColorAt(x, y) != color && !Board.getBoard().isEmpty(x, y)) {
				Board.getBoard().getPiece(x, y).kill();
				System.out.println("bishop attach");
				return true;
			}
			else if (Board.getBoard().isEmpty(x, y))
				return true;
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
		return " QUEEN";
	}

	@Override
	public void kill() {
		state = INACTIVE;
		
	}

}
