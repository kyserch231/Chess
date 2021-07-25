package chess;

import java.util.ArrayList;

/*
 *   -----------------------------------------------
 * 	| 0,0 | 1,0 | 2,0 | 3,0 | 4,0 | 5,0 | 6,0 | 7,0 |
 * 	|rook | kni |bish |king |queen|bish | kni |rook |
 *  |-----|-----|-----|-----|-----|-----|-----|-----|
 * 	| 0,1 | 1,1 | 2,1 | 3,1 | 4,1 | 5,1 | 6,1 | 7,1 |
 *   ----- ----- ----- ----- ----- ----- ----- -----
 * 	| 0,2 | 1,1 | 2,1 | 3,1 | 4,1 | 5,1 | 6,1 | 7,1 |
 *   ----- ----- ----- ----- ----- ----- ----- -----
 * 	| 0,3 | 1,1 | 2,1 | 3,1 | 4,1 | 5,1 | 6,1 | 7,1 |
 *   ----- ----- ----- ----- ----- ----- ----- -----
 * 	| 0,4 | 1,1 | 2,1 | 3,1 | 4,1 | 5,1 | 6,1 | 7,1 |
 *   ----- ----- ----- ----- ----- ----- ----- ----- 
 * 	| 0,5 | 1,1 | 2,1 | 3,1 | 4,1 | 5,1 | 6,1 | 7,1 |
 *   ----- ----- ----- ----- ----- ----- ----- ----- 
 * 	| 0,6 | 1,1 | 2,1 | 3,1 | 4,1 | 5,1 | 6,1 | 7,1 |
 *   ----- ----- ----- ----- ----- ----- ----- ----- 
 * 	| 0,7 | 1,1 | 2,1 | 3,1 | 4,1 | 5,1 | 6,1 | 7,1 |
 *   ----- ----- ----- ----- ----- ----- ----- -----
 */
public class Board implements Constants{
	

	public static Board gameBoard = null;
	public int turn = WHITE;
	
	public static Board getBoard(){
		if(gameBoard == null){
			gameBoard = new Board();
		}
		return gameBoard;
	}
	
	Piece[][] chessBoard;
	ArrayList<Piece> WhitePieces;
	ArrayList<Piece> BlackPieces;
	
	private Board(){
		WhitePieces= new ArrayList<Piece>();
		BlackPieces= new ArrayList<Piece>();
		initializeBoard();
		
	}
	
	public void initializeBoard(){

		BlackPieces.add(new Rook(0,0,BLACK));
		BlackPieces.add(new Knight(1,0,BLACK));
		BlackPieces.add(new Bishop(2,0,BLACK));
		BlackPieces.add(new King(3,0,BLACK));
		BlackPieces.add(new Queen(4,0,BLACK));
		BlackPieces.add(new Bishop(5,0,BLACK));
		BlackPieces.add(new Knight(6,0,BLACK));
		BlackPieces.add(new Rook(7,0,BLACK));
		
		for (int i = 0; i < 8; i++){
			BlackPieces.add(new Pawn(i,1,BLACK));
		}
		
		WhitePieces.add(new Rook(0,7,WHITE));
		WhitePieces.add(new Knight(1,7,WHITE));
		WhitePieces.add(new Bishop(2,7,WHITE));
		WhitePieces.add(new King(3,7,WHITE));
		WhitePieces.add(new Queen(4,7,WHITE));
		WhitePieces.add(new Bishop(5,7,WHITE));
		WhitePieces.add(new Knight(6,7,WHITE));
		WhitePieces.add(new Rook(7,7,WHITE));
		
		for (int i = 0; i < 8; i++){
			WhitePieces.add(new Pawn(i,6,WHITE));
		}
		
		chessBoard = new Piece[9][9];
		for (Piece b: BlackPieces){
			chessBoard[b.getLocation().getPositionX()][b.getLocation().getPositionY()]= b;
		}
		for (Piece w: WhitePieces){
			chessBoard[w.getLocation().getPositionX()][w.getLocation().getPositionY()]= w;
		}
		turn = WHITE;
	}

	
	public boolean isEmpty(int x, int y){
		return (chessBoard[x][y] == null);
		
	}
	

	public int getColorAt(int x, int y){
		if (chessBoard[x][y]==null)
			return -1;
		if(chessBoard[x][y].isBlack())
			return BLACK;
		else 
			return WHITE;
	}
	
	public Piece getPiece(int x, int y) {
		if (chessBoard[x][y]!=null)
			return chessBoard[x][y];
		else 
			return null;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public void setPiece(Piece p) {
		chessBoard[p.getLocation().getPositionX()][p.getLocation().getPositionY()] = p;
	}
	
	public void setToEmpty(int x, int y) {
		chessBoard[x][y] = null;
	}
	
	public void togleTurn() {
		if(turn == WHITE) {
			turn = BLACK;
		}
		else {
			turn = WHITE;
		}
	}
	
	public void printBoard() {
		
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++){
				if (chessBoard[i][j] == null)
					System.out.print("|      ");
				else
					System.out.print("|" + chessBoard[i][j].getName());
			}
			System.out.println();
			System.out.print("|------|------|------|------|------|------|------|------|");
			System.out.println();
		}
	}

	public void setTurn(int x) {
		turn = x;
	}
}
