package chess;

public class Pawn extends Movable implements Constants, Piece {

	// determines if the pawn has moved before
	boolean hasMoved;
	
	public Pawn(int x, int y, int clr) {
		position.setPosition(x,y);
		color = clr;
		state = ACTIVE;
		hasMoved = false;
	}
	
	@Override
	public boolean isValidMove(int x, int y) {
		
		// calculate the distances b/w selected destination and current position
		int disX = (x - position.getPositionX());
		int disY = (y - position.getPositionY());
		
		System.out.println(disX + ", " + disY);
		
		// pawn can move two spaces up on first move, one space up, and one space diagonally to attach
		if (color == BLACK) {
			
			if (Board.getBoard().isEmpty(x, y)) {
				if (hasMoved && disY == 1 && disX == 0)
					return true;
			
				else if (!hasMoved && (disY == 2 || disY == 1) && disX == 0)
					return true;
			} else if (hasMoved && disY == 1 && (disX == 1 || disX == -1) && Board.getBoard().getColorAt(x, y) == WHITE) {
				Board.getBoard().getPiece(x, y).kill();
				return true;
			}
		}
		
		if (color == WHITE) {
			
			if (Board.getBoard().isEmpty(x, y)) {
				if (hasMoved && disY == -1 && disX == 0)
					return true;
			
				else if (!hasMoved && (disY == -2 || disY == -1) && disX == 0)
					return true;
			} else if (hasMoved && disY == -1 && (disX == 1 || disX == -1) && Board.getBoard().getColorAt(x, y) == BLACK) {
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
		hasMoved = true;
	}

	@Override
	public String getName() {
		return " PAWN ";
	}

	@Override
	public void kill() {
		state = INACTIVE;
	}

}
