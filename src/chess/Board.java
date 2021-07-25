package chess;

import static chess.Constants.BLACK;
import static chess.Constants.WHITE;
import static chess.Constants.ROWS;
import static chess.Constants.COLS;

import java.util.ArrayList;

/*   -----------------------------------------------
 *  | 0,0 | 1,0 | 2,0 | 3,0 | 4,0 | 5,0 | 6,0 | 7,0 |
 *  |rook | kni |bish |king |queen|bish | kni |rook |
 *  |-----|-----|-----|-----|-----|-----|-----|-----|
 *  | 0,1 | 1,1 | 2,1 | 3,1 | 4,1 | 5,1 | 6,1 | 7,1 |
 *  |pawn |pawn |pawn |pawn |pawn |pawn |pawn |pawn |
 *  |-----|-----|-----|-----|-----|-----|-----|-----|
 *  | 0,2 | 1,2 | 2,2 | 3,2 | 4,2 | 5,2 | 6,2 | 7,2 |
 *  |-----|-----|-----|-----|-----|-----|-----|-----|
 *  | 0,3 | 1,3 | 2,3 | 3,3 | 4,3 | 5,3 | 6,3 | 7,3 |
 *  |-----|-----|-----|-----|-----|-----|-----|-----|
 *  | 0,4 | 1,4 | 2,4 | 3,4 | 4,4 | 5,4 | 6,4 | 7,4 |
 *  |-----|-----|-----|-----|-----|-----|-----|-----|
 *  | 0,5 | 1,5 | 2,5 | 3,5 | 4,5 | 5,5 | 6,5 | 7,5 |
 *  |-----|-----|-----|-----|-----|-----|-----|-----|
 *  |pawn |pawn |pawn |pawn |pawn |pawn |pawn |pawn |
 *  | 0,6 | 1,6 | 2,6 | 3,6 | 4,6 | 5,6 | 6,6 | 7,6 |
 *  |-----|-----|-----|-----|-----|-----|-----|-----|
 *  |rook | kni |bish |king |queen|bish | kni |rook |
 *  | 0,7 | 1,7 | 2,7 | 3,7 | 4,7 | 5,7 | 6,7 | 7,7 |
 *   -----------------------------------------------
 */

/**
 * Matrix of board.
 * @author emilydeppe
 *
 */
<<<<<<< HEAD
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
=======
public final class Board {

    /** Create and empty game board. */
    static Board gameBoard = null;

    /** White player gets first move. */
    private int turn = WHITE;

    /**
     * @return board if it has been initialized
     */
    public static Board getBoard() {
        if (gameBoard == null) {
            gameBoard = new Board();
        }
        return gameBoard;
    }
    /** Matrix of chess pieces. */
    private Piece[][] chessBoard;

    /** Array that contains all white pieces. */
    private ArrayList<Piece> whitePieces;

    /** Array that contains all black pieces. */
    private ArrayList<Piece> blackPieces;

    private Board() {
        turn = WHITE;
        whitePieces = new ArrayList<Piece>();
        blackPieces = new ArrayList<Piece>();
        initializeBoard();
    }

    /**
     *  Creates piece for board and places them on the game board.
     */
    public void initializeBoard() {

        int position = 0;
        blackPieces.add(new Rook(position++, 0, BLACK));
        blackPieces.add(new Knight(position++, 0, BLACK));
        blackPieces.add(new Bishop(position++, 0, BLACK));
        blackPieces.add(new King(position++, 0, BLACK));
        blackPieces.add(new Queen(position++, 0, BLACK));
        blackPieces.add(new Bishop(position++, 0, BLACK));
        blackPieces.add(new Knight(position++, 0, BLACK));
        blackPieces.add(new Rook(position++, 0, BLACK));

        for (int i = 0; i < position; i++) {
            blackPieces.add(new Pawn(i, 1, BLACK));
        }
        position = 0;
        whitePieces.add(new Rook(position++, ROWS - 1, WHITE));
        whitePieces.add(new Knight(position++, ROWS - 1, WHITE));
        whitePieces.add(new Bishop(position++, ROWS - 1, WHITE));
        whitePieces.add(new King(position++, ROWS - 1, WHITE));
        whitePieces.add(new Queen(position++, ROWS - 1, WHITE));
        whitePieces.add(new Bishop(position++, ROWS - 1, WHITE));
        whitePieces.add(new Knight(position++, ROWS - 1, WHITE));
        whitePieces.add(new Rook(position++, ROWS - 1, WHITE));

        for (int i = 0; i < position; i++) {
            whitePieces.add(new Pawn(i, ROWS - 2, WHITE));
        }

        chessBoard = new Piece[ROWS + 1][COLS + 1];
        for (Piece b: blackPieces) {
            chessBoard[b.getLoc().getPosX()]
                    [b.getLoc().getPosY()] = b;
        }
        for (Piece w: whitePieces) {
            chessBoard[w.getLoc().getPosX()]
                    [w.getLoc().getPosY()] = w;
        }
    }

    /**
     * @param x
     * @param y
     * @return true if square is empty and false if it is not.
     */
    public boolean isEmpty(final int x, final int y) {
        return (chessBoard[x][y] == null);
    }

    /**
     * @param x
     * @param y
     * @return color at location (x,y)
     */
    public int getColorAt(final int x, final int y) {
        if (chessBoard[x][y] == null) {
            return -1;
        }
        if (chessBoard[x][y].isBlack()) {
            return BLACK;
        } else {
            return WHITE;
        }
    }

    /**
     * @param x
     * @param y
     * @return piece the location (x,Y)
     */
    public Piece getPiece(final int x, final int y) {
        if (chessBoard[x][y] != null) {
            return chessBoard[x][y];
        } else {
            return null;
        }
    }

    /**
     * @return the color of the player whose turn it is.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Sets the location the the piece p.
     * @param p
     */
    public void setPiece(final Piece p) {
        chessBoard[p.getLoc().getPosX()][p.getLoc().getPosY()] = p;
    }

    /**
     * Sets location (x,y) to empty.
     * @param x
     * @param y
     */
    public void setToEmpty(final int x, final int y) {
        chessBoard[x][y] = null;
    }

    /**
     * Switches the color of whose turn it is.
     */
    public void togleTurn() {
        if (turn == WHITE) {
            turn = BLACK;
        } else {
            turn = WHITE;
        }
    }

    /**
     * Prints the current board to the console window.
     */
    public void printBoard() {

        for (int j = 0; j < ROWS; j++) {
            for (int i = 0; i < COLS; i++) {
                if (chessBoard[i][j] == null) {
                    System.out.print("|      ");
                } else {
                    System.out.print("|" + chessBoard[i][j]
                            .getName());
                }
            }
            System.out.println();
            System.out.print("|------|------|------|------|"
                    + "------|------|------|------|");
            System.out.println();
        }
    }

>>>>>>> 67ff0f24b8d88d0834eb3b1247088c6e99800d3e
}
