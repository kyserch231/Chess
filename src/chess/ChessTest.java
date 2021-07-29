package chess;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static chess.Constants.COL_0;
import static chess.Constants.COL_1;
import static chess.Constants.COL_2;
import static chess.Constants.COL_3;
import static chess.Constants.COL_4;
import static chess.Constants.COL_5;
import static chess.Constants.COL_6;
import static chess.Constants.COL_7;
import static chess.Constants.ROW_0;
import static chess.Constants.ROW_2;
import static chess.Constants.ROW_3;
import static chess.Constants.ROW_4;
import static chess.Constants.ROW_5;
import static chess.Constants.ROW_6;
import static chess.Constants.ROW_7;

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
public class ChessTest {

    /**
     * Makes a new board before each test.
     */
    @Before
    public void buildBoard() {
        Board.getBoard().resetBoard();
    }

    /**
     * Test the King for valid moves.
     */
    @Test
    public void validMovesKing() {

        /* Move black knight for testing. */
        assertTrue(Board.getBoard().getPiece(COL_6, ROW_0) instanceof Knight);
        Board.getBoard().getPiece(COL_6, ROW_0).move(COL_5, ROW_2);
        assertTrue(Board.getBoard().getPiece(COL_5, ROW_2) instanceof Knight);
        Board.getBoard().getPiece(COL_5, ROW_2).move(COL_4, ROW_4);
        assertTrue(Board.getBoard().getPiece(COL_4, ROW_4) instanceof Knight);
        Board.getBoard().getPiece(COL_4, ROW_4).move(COL_3, ROW_6);
        assertTrue(Board.getBoard().getPiece(COL_3, ROW_6) instanceof Knight);

        /* Test if killing black knight is valid. */
        assertTrue(Board.getBoard().getPiece(COL_3, ROW_7).isValidMove(COL_3, ROW_6));

        /* Make move to kill black knight and switch turns so that king can make another move. */
        Board.getBoard().getPiece(COL_3, ROW_7).move(COL_3, ROW_6);
        Board.getBoard().togleTurn();

        /* Test if moving to empty square is valid. */
        assertTrue(Board.getBoard().getPiece(COL_3, ROW_6).isValidMove(COL_3, ROW_5));
    }

    /**
     * Test the King for invalid moves.
     */
    @Test
    public void invalidMovesKing() {

        /* Test if selected square contains a piece of the same color. */
        assertFalse(Board.getBoard().getPiece(COL_3, ROW_7).isValidMove(COL_3, ROW_6));
    }

    /**
     * Test the Queen for valid moves.
     */
    @Test
    public void validMovesQueen() {

        /* Move black knight for testing. */
        assertTrue(Board.getBoard().getPiece(COL_6, ROW_0) instanceof Knight);
        Board.getBoard().getPiece(COL_6, ROW_0).move(COL_5, ROW_2);
        assertTrue(Board.getBoard().getPiece(COL_5, ROW_2) instanceof Knight);
        Board.getBoard().getPiece(COL_5, ROW_2).move(COL_4, ROW_4);
        assertTrue(Board.getBoard().getPiece(COL_4, ROW_4) instanceof Knight);
        Board.getBoard().getPiece(COL_4, ROW_4).move(COL_3, ROW_6);
        assertTrue(Board.getBoard().getPiece(COL_3, ROW_6) instanceof Knight);

        /* Test if killing black knight is valid. */
        assertTrue(Board.getBoard().getPiece(COL_4, ROW_7).isValidMove(COL_3, ROW_6));

        /* Make move to kill black knight and switch turns so that king can make another move. */
        Board.getBoard().getPiece(COL_4, ROW_7).move(COL_3, ROW_6);

        Board.getBoard().togleTurn();

        /* Test if moving to empty square is valid. */
        assertTrue(Board.getBoard().getPiece(COL_3, ROW_6).isValidMove(COL_3, ROW_3));
    }

    /**
     * Test the Queen for invalid moves.
     */
    @Test
    public void invalidMovesQueen() {

        /* Test if selected square contains a piece of the same color. */
        assertFalse(Board.getBoard().getPiece(COL_4, ROW_7).isValidMove(COL_4, ROW_6));

        /* Test if top right move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_4, ROW_7).isValidMove(COL_6, ROW_5));

        /* Test if top left move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_4, ROW_7).isValidMove(COL_1, ROW_4));

        /* Test if up move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_4, ROW_7).isValidMove(COL_4, ROW_4));

        Board.getBoard().togleTurn();

        /* Test if bottom right move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_4, ROW_0).isValidMove(COL_6, ROW_2));

        /* Test if bottom left move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_4, ROW_0).isValidMove(COL_1, ROW_3));

        Board.getBoard().getPiece(COL_6, ROW_0).move(COL_5, ROW_2);
        Board.getBoard().getPiece(COL_1, ROW_0).move(COL_2, ROW_2);

        /* Test if right across move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_4, ROW_0).isValidMove(COL_6, ROW_0));

        /* Test if left across move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_4, ROW_0).isValidMove(COL_1, ROW_0));

        /* Test if down move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_4, ROW_0).isValidMove(COL_4, ROW_4));

    }

    /**
     * Test the Bishop for invalid moves.
     */
    @Test
    public void invalidMovesBishop() {

        /* Test if selected square contains a piece of the same color. */
        assertFalse(Board.getBoard().getPiece(COL_5, ROW_7).isValidMove(COL_4, ROW_6));

        /* Test if top right move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_5, ROW_7).isValidMove(COL_7, ROW_5));

        /* Test if top left move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_5, ROW_7).isValidMove(COL_3, ROW_5));

        Board.getBoard().togleTurn();

        /* Test if bottom right move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_5, ROW_0).isValidMove(COL_7, ROW_2));

        /* Test if bottom left move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_5, ROW_0).isValidMove(COL_3, ROW_2));
    }

    /**
     * Test the Rook for invalid moves.
     */
    @Test
    public void invalidMovesRook() {

        /* Test if selected square contains a piece of the same color */
        assertFalse(Board.getBoard().getPiece(COL_0, ROW_7).isValidMove(COL_1, ROW_7));

        /* Test if up move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_0, ROW_7).isValidMove(COL_0, ROW_4));

        /* Move nights */
        Board.getBoard().getPiece(COL_6, ROW_0).move(COL_5, ROW_2);
        Board.getBoard().getPiece(COL_1, ROW_0).move(COL_2, ROW_2);

        /* Test if right move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_0, ROW_7).isValidMove(COL_6, ROW_7));

        /* Test if left move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_7, ROW_7).isValidMove(COL_1, ROW_7));

        Board.getBoard().togleTurn();

        /* Test if down move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(COL_0, ROW_0).isValidMove(COL_0, ROW_2));
    }
}