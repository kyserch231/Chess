package chess;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

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
        assertTrue(Board.getBoard().getPiece(6, 0) instanceof Knight);
        Board.getBoard().getPiece(6, 0).move(5, 2);
        assertTrue(Board.getBoard().getPiece(5, 2) instanceof Knight);
        Board.getBoard().getPiece(5, 2).move(4, 4);
        assertTrue(Board.getBoard().getPiece(4, 4) instanceof Knight);
        Board.getBoard().getPiece(4, 4).move(3, 6);
        assertTrue(Board.getBoard().getPiece(3, 6) instanceof Knight);

        /* Test if killing black knight is valid. */
        assertTrue(Board.getBoard().getPiece(3, 7).isValidMove(3, 6));

        /* Make move to kill black knight and switch turns so that king can make another move. */
        Board.getBoard().getPiece(3, 7).move(3, 6);
        Board.getBoard().togleTurn();

        /* Test if moving to empty square is valid. */
        assertTrue(Board.getBoard().getPiece(3, 6).isValidMove(3, 5));
    }

    /**
     * Test the King for invalid moves.
     */
    @Test
    public void invalidMovesKing() {

        /* Test if selected square contains a piece of the same color. */
        assertFalse(Board.getBoard().getPiece(3, 7).isValidMove(3, 6));
    }

    /**
     * Test the Queen for valid moves.
     */
    @Test
    public void validMovesQueen() {

        /* Move black knight for testing. */
        assertTrue(Board.getBoard().getPiece(6, 0) instanceof Knight);
        Board.getBoard().getPiece(6, 0).move(5, 2);
        assertTrue(Board.getBoard().getPiece(5, 2) instanceof Knight);
        Board.getBoard().getPiece(5, 2).move(4, 4);
        assertTrue(Board.getBoard().getPiece(4, 4) instanceof Knight);
        Board.getBoard().getPiece(4, 4).move(3, 6);
        assertTrue(Board.getBoard().getPiece(3, 6) instanceof Knight);

        /* Test if killing black knight is valid. */
        assertTrue(Board.getBoard().getPiece(4, 7).isValidMove(3, 6));

        /* Make move to kill black knight and switch turns so that king can make another move. */
        Board.getBoard().getPiece(4, 7).move(3, 6);

        Board.getBoard().togleTurn();

        /* Test if moving to empty square is valid. */
        assertTrue(Board.getBoard().getPiece(3, 6).isValidMove(3, 3));
    }

    /**
     * Test the Queen for invalid moves.
     */
    @Test
    public void invalidMovesQueen() {

        /* Test if selected square contains a piece of the same color. */
        assertFalse(Board.getBoard().getPiece(4, 7).isValidMove(4, 6));

        /* Test if top right move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(4, 7).isValidMove(6, 5));

        /* Test if top left move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(4, 7).isValidMove(1, 4));

        /* Test if up move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(4, 7).isValidMove(4, 4));

        Board.getBoard().togleTurn();

        /* Test if bottom right move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(4, 0).isValidMove(6, 2));

        /* Test if bottom left move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(4, 0).isValidMove(1, 3));

        Board.getBoard().getPiece(6, 0).move(5, 2);
        Board.getBoard().getPiece(1, 0).move(2, 2);

        /* Test if right across move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(4, 0).isValidMove(6, 0));

        /* Test if left across move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(4, 0).isValidMove(1, 0));

        /* Test if down move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(4, 0).isValidMove(4, 4));

    }

    /**
     * Test the Bishop for invalid moves.
     */
    @Test
    public void invalidMovesBishop() {

        /* Test if selected square contains a piece of the same color. */
        assertFalse(Board.getBoard().getPiece(5, 7).isValidMove(4, 6));

        /* Test if top right move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(5, 7).isValidMove(7, 5));

        /* Test if top left move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(5, 7).isValidMove(3, 5));

        Board.getBoard().togleTurn();

        /* Test if bottom right move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(5, 0).isValidMove(7, 2));

        /* Test if bottom left move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(5, 0).isValidMove(3, 2));
    }

    /**
     * Test the Rook for invalid moves.
     */
    @Test
    public void invalidMovesRook() {

        /* Test if selected square contains a piece of the same color */
        assertFalse(Board.getBoard().getPiece(0, 7).isValidMove(1, 7));

        /* Test if up move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(0, 7).isValidMove(0, 4));

        /* Move nights */
        Board.getBoard().getPiece(6, 0).move(5, 2);
        Board.getBoard().getPiece(1, 0).move(2, 2);

        /* Test if right move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(0, 7).isValidMove(6, 7));

        /* Test if left move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(7, 7).isValidMove(1, 7));

        Board.getBoard().togleTurn();

        /* Test if down move with piece in between is invalid */
        assertFalse(Board.getBoard().getPiece(0, 0).isValidMove(0, 2));
    }
}
