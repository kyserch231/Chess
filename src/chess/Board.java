package chess;

import static chess.Constants.BLACK;
import static chess.Constants.WHITE;
import static chess.Constants.ROWS;
import static chess.Constants.COLS;
import static chess.Constants.COL_0;
import static chess.Constants.COL_1;
import static chess.Constants.COL_2;
import static chess.Constants.COL_3;
import static chess.Constants.COL_4;
import static chess.Constants.COL_5;
import static chess.Constants.COL_6;
import static chess.Constants.COL_7;
import static chess.Constants.ROW_0;
import static chess.Constants.ROW_1;
import static chess.Constants.ROW_6;
import static chess.Constants.ROW_7;


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
public class Board {

    /** Create and empty game board. */
    private static Board gameBoard = null;
    
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
    private static Piece[][] chessBoard;

    /** Matrix of chess pieces. */
    private static Piece[][] chessBoardSaved;
    
    /** Array that contains all white pieces. */
    private static ArrayList<Piece> whitePieces;

    /** Array that contains all black pieces. */
    private static ArrayList<Piece> blackPieces;

    /** Array that contains all white pieces. */
    private static ArrayList<Piece> whitePiecesSaved;

    /** Array that contains all black pieces. */
    private static ArrayList<Piece> blackPiecesSaved;
    
    /**
     * Initializes board and pieces.
     */
    public Board() {
        initializeBoard();
    }

    /**
     *  Creates piece for board and places them on the game board.
     */
    public void initializeBoard() {

        turn = WHITE;
        whitePieces = new ArrayList<Piece>();
        blackPieces = new ArrayList<Piece>();

        blackPieces.add(new Rook(COL_0, ROW_0, BLACK));
        blackPieces.add(new Knight(COL_1, ROW_0, BLACK));
        blackPieces.add(new Bishop(COL_2, ROW_0, BLACK));
        blackPieces.add(new King(COL_3, ROW_0, BLACK));
        blackPieces.add(new Queen(COL_4, ROW_0, BLACK));
        blackPieces.add(new Bishop(COL_5, ROW_0, BLACK));
        blackPieces.add(new Knight(COL_6, ROW_0, BLACK));
        blackPieces.add(new Rook(COL_7, ROW_0, BLACK));

        for (int i = 0; i < COLS; i++) {
            blackPieces.add(new Pawn(i, ROW_1, BLACK));
        }

        whitePieces.add(new Rook(COL_0, ROW_7, WHITE));
        whitePieces.add(new Knight(COL_1, ROW_7, WHITE));
        whitePieces.add(new Bishop(COL_2, ROW_7, WHITE));
        whitePieces.add(new King(COL_3, ROW_7, WHITE));
        whitePieces.add(new Queen(COL_4, ROW_7, WHITE));
        whitePieces.add(new Bishop(COL_5, ROW_7, WHITE));
        whitePieces.add(new Knight(COL_6, ROW_7, WHITE));
        whitePieces.add(new Rook(COL_7, ROW_7, WHITE));

        for (int i = 0; i < COLS; i++) {
            whitePieces.add(new Pawn(i, ROW_6, WHITE));
        }

        chessBoard = new Piece[ROWS + 1][COLS + 1];
        for (Piece b: blackPieces) {
            chessBoard[b.getLoc().getPosX()][b.getLoc().getPosY()] = b;
        }
        for (Piece w: whitePieces) {
            chessBoard[w.getLoc().getPosX()][w.getLoc().getPosY()] = w;
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
    public static void setPiece(final Piece p) {
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
    * @param color of king to check
    * @return true if a piece has an opposite king in check
    */
	public static boolean isCheck(int color){
		
		if (color == BLACK) {
			
			int xBlack = getBlackX();
			int yBlack = getBlackY();
			System.out.println("xBlack = " + xBlack + " , yBlack = " + yBlack);
			
			for (int i = 0; i < whitePieces.size(); i++) {
				if (whitePieces.get(i).hasCheck(xBlack, yBlack)) {
							return true;
				}
			}
			return false;
		} else {
			
			int xWhite = getWhiteX();
			int yWhite = getWhiteY();
			System.out.println("xWhite = " + xWhite + " , yWhite = " + yWhite);
			
			for (int i = 0; i < blackPieces.size(); i++) {
				if (blackPieces.get(i).hasCheck(xWhite, yWhite)) {
						return true;
				}
			}
			return false;			
		}
		
	}
	
	public static void saveChessBoard() {
		

		/* Create new board just like like the other board */
		chessBoardSaved = new Piece[ROWS + 1][COLS + 1];
		
		whitePiecesSaved = new ArrayList<Piece>();
		blackPiecesSaved = new ArrayList<Piece>();
//        for (Piece w: whitePieces) {
//        	Piece wAdd = w;
//            whitePiecesSaved.add(wAdd);
//        }
    
        whitePiecesSaved.clear();
        whitePiecesSaved.add(new Rook(whitePieces.get(0).getLoc().getPosX(), whitePieces.get(0).getLoc().getPosY(), WHITE));
        whitePiecesSaved.add(new Knight(whitePieces.get(1).getLoc().getPosX(), whitePieces.get(1).getLoc().getPosY(), WHITE));
        whitePiecesSaved.add(new Bishop(whitePieces.get(2).getLoc().getPosX(), whitePieces.get(2).getLoc().getPosY(), WHITE));
        whitePiecesSaved.add(new King(whitePieces.get(3).getLoc().getPosX(), whitePieces.get(3).getLoc().getPosY(), WHITE));
        whitePiecesSaved.add(new Queen(whitePieces.get(4).getLoc().getPosX(), whitePieces.get(4).getLoc().getPosY(), WHITE));
        whitePiecesSaved.add(new Bishop(whitePieces.get(5).getLoc().getPosX(), whitePieces.get(5).getLoc().getPosY(), WHITE));
        whitePiecesSaved.add(new Knight(whitePieces.get(6).getLoc().getPosX(), whitePieces.get(6).getLoc().getPosY(), WHITE));
        whitePiecesSaved.add(new Rook(whitePieces.get(7).getLoc().getPosX(), whitePieces.get(7).getLoc().getPosY(), WHITE));
        
        for (int i = 8; i < 16; i++) {
        	whitePiecesSaved.add(new Pawn(whitePieces.get(i).getLoc().getPosX(), whitePieces.get(i).getLoc().getPosY(), WHITE));
        }
        
        blackPiecesSaved.clear();
        blackPiecesSaved.add(new Rook(blackPieces.get(0).getLoc().getPosX(), blackPieces.get(0).getLoc().getPosY(), BLACK));
        blackPiecesSaved.add(new Knight(blackPieces.get(1).getLoc().getPosX(), blackPieces.get(1).getLoc().getPosY(), BLACK));
        blackPiecesSaved.add(new Bishop(blackPieces.get(2).getLoc().getPosX(), blackPieces.get(2).getLoc().getPosY(), BLACK));
        blackPiecesSaved.add(new King(blackPieces.get(3).getLoc().getPosX(), blackPieces.get(3).getLoc().getPosY(), BLACK));
        blackPiecesSaved.add(new Queen(blackPieces.get(4).getLoc().getPosX(), blackPieces.get(4).getLoc().getPosY(), BLACK));
        blackPiecesSaved.add(new Bishop(blackPieces.get(5).getLoc().getPosX(), blackPieces.get(5).getLoc().getPosY(), BLACK));
        blackPiecesSaved.add(new Knight(blackPieces.get(6).getLoc().getPosX(), blackPieces.get(6).getLoc().getPosY(), BLACK));
        blackPiecesSaved.add(new Rook(blackPieces.get(7).getLoc().getPosX(), blackPieces.get(7).getLoc().getPosY(), BLACK));
        
        for (int i = 8; i < 16; i++) {
            blackPiecesSaved.add(new Pawn(blackPieces.get(i).getLoc().getPosX(), blackPieces.get(i).getLoc().getPosY(), BLACK));
        }
        
//		blackPiecesSaved = new ArrayList<Piece>();
//		for (Piece b: blackPieces) {
//			Piece bAdd = b;
//			blackPiecesSaved.add(bAdd);
//        }
		
        for (Piece b: blackPiecesSaved) {
            chessBoardSaved[b.getLoc().getPosX()][b.getLoc().getPosY()] = b;
        }
        for (Piece w: whitePiecesSaved) {
            chessBoardSaved[w.getLoc().getPosX()][w.getLoc().getPosY()] = w;
        }
        System.out.print("Board Saved\n");
	}

	public static void undoChessBoard() {
		
		/* Create new board just like like the other board */
		//chessBoard = null;
		
		whitePieces.clear();
        for (Piece w: whitePiecesSaved) {
        	Piece wAdd = w;
            whitePieces.add(wAdd);
        }
    
		blackPieces.clear();
		for (Piece b: blackPiecesSaved) {
			Piece bAdd = b;
            blackPieces.add(bAdd);
        }
		
		/* Clear current board */
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chessBoard[i][j] = null;
			}
		}
		
		/* Add saved pieces */
        for (Piece b: blackPieces) {
            chessBoard[b.getLoc().getPosX()][b.getLoc().getPosY()] = b;
        }
        for (Piece w: whitePieces) {
            chessBoard[w.getLoc().getPosX()][w.getLoc().getPosY()] = w;
        }
        System.out.print("Undo Board\n");
	}

	/**
	 * @return x location of black king
	 */
	public static int getBlackX() {
		return blackPieces.get(3).getLoc().getPosX();
	}
	
	/**
	 * @return Y location of black king
	 */
	public static int getBlackY() {
		return blackPieces.get(3).getLoc().getPosY();
	}
	
	/**
	 * @return x location of black king
	 */
	public static int getWhiteX() {
		return whitePieces.get(3).getLoc().getPosX();
	}
	
	/**
	 * @return Y location of black king
	 */
	public static int getWhiteY() {
		return whitePieces.get(3).getLoc().getPosY();
	}

	/**
	 * @return ArrayList of white pieces
	 */
	public static ArrayList<Piece> getWhitePieces() {
		return whitePieces;
	}
	
	/**
	 * @return ArrayList of black pieces
	 */
	public static ArrayList<Piece> getBlackPieces() {
		return blackPieces;
	}


    /**
     * Resets board to starting position.
     */
    public void resetBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                chessBoard[i][j] = null;
            }
        }
        initializeBoard();
    }
}
