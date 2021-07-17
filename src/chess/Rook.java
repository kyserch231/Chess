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
		int disX = (x - position.getPositionX());
		int disY = (y - position.getPositionY());
		
		if (disY == 0 || disX == 0) {
			
			// determines if there are any pieces in the way between selected square and current square,
			// move in invalid if there are any pieces
			if (disY == 0) {
				// move right across the board
				if (disX > 0) {
					for (int i = position.getPositionX(); i < x; ++i) {
						if (!Board.getBoard().isEmpty(i+1, y) && i+1 != x)
							return false;
					}
				} 
				// move left across the board
				else if (disX < 0) {
					for (int i = position.getPositionX(); i < x; --i) {
						if (!Board.getBoard().isEmpty(i-1, y) && i-1 != x)
							return false;
					}
				}
			}
			else if (disX == 0) {
				// move down across the board
				if (disY > 0) {
					for (int i = position.getPositionY(); i < y; ++i) {
						if (!Board.getBoard().isEmpty(x, i+1) && i+1 != y)
							return false;
					}
				} 
				// move up across the board
				else if (disY < 0) {
					for (int i = position.getPositionY(); i < y; --i) {
						if (!Board.getBoard().isEmpty(x, i-1) && i-1 != y)
							return false;
					}
				}
			}
			
			// if selected location contains another piece in the same color, move is invalid
			if (Board.getBoard().getColorAt(x, y) == color)
				return false;
			
			// if selected location contains a piece in the opposite color, then that piece is killed
			if (Board.getBoard().getColorAt(x, y) != color && !Board.getBoard().isEmpty(x, y)) {
				Board.getBoard().getPiece(x, y).kill();
				System.out.println("rook attach");
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
		return " ROOK ";
	}

	@Override
	public void kill() {
		state = INACTIVE;
	}

}
