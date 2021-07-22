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
		if ((disX == 1 && disY == 0) || (disX == 0 && disY == 1) || (disX == 1 && disY == 1)) {
		
			if(color == BLACK && Board.getBoard().getTurn() == BLACK) {
				// if selected location contains another piece in the same color, move is invalid
				if (Board.getBoard().getColorAt(x, y) == color)
					return false;
				
				// if selected location contains a piece in the opposite color, then that piece is killed
				if (Board.getBoard().getColorAt(x, y) != color && !Board.getBoard().isEmpty(x, y)) {
					Board.getBoard().getPiece(x, y).kill();
					Board.getBoard().togleTurn();
					return true;
				}
				else if (Board.getBoard().isEmpty(x, y)) {
					Board.getBoard().togleTurn();
					return true;
				}
			}
			if(color == WHITE && Board.getBoard().getTurn() == WHITE) {
				// if selected location contains another piece in the same color, move is invalid
				if (Board.getBoard().getColorAt(x, y) == color)
					return false;
				
				// if selected location contains a piece in the opposite color, then that piece is killed
				if (Board.getBoard().getColorAt(x, y) != color && !Board.getBoard().isEmpty(x, y)) {
					Board.getBoard().getPiece(x, y).kill();
					Board.getBoard().togleTurn();
					return true;
				}
				else if (Board.getBoard().isEmpty(x, y)) {
					Board.getBoard().togleTurn();
					return true;
				}
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
		return " KING ";
	}


	@Override
	public void kill() {
		
		// pop up of who won
		state = INACTIVE;
		
	}

}
