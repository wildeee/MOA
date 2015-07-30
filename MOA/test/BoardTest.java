/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import moa.Board;
import moa.Config;
import moa.EMovementType;
import moa.InvalidMovementException;
import moa.Piece;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guest-BHuB2B
 */
public class BoardTest {

    public BoardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    private Board getTabuleiroResolvido() {
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(1));
        pieces.add(new Piece(2));
        pieces.add(new Piece(3));
        pieces.add(new Piece(4));
        pieces.add(new Piece(12));
        pieces.add(new Piece(13));
        pieces.add(new Piece(14));
        pieces.add(new Piece(5));
        pieces.add(new Piece(11));
        pieces.add(new Piece(Config.EmptyPiece));
        pieces.add(new Piece(15));
        pieces.add(new Piece(6));
        pieces.add(new Piece(10));
        pieces.add(new Piece(9));
        pieces.add(new Piece(8));
        pieces.add(new Piece(7));
        return new Board(pieces);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void PegaPecaVazia() {
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(1));
        pieces.add(new Piece(2));
        pieces.add(new Piece(3));
        pieces.add(new Piece(4));
        pieces.add(new Piece(12));
        pieces.add(new Piece(13));
        pieces.add(new Piece(14));
        pieces.add(new Piece(5));
        pieces.add(new Piece(11));
        pieces.add(new Piece(Config.EmptyPiece));
        pieces.add(new Piece(15));
        pieces.add(new Piece(6));
        pieces.add(new Piece(10));
        pieces.add(new Piece(9));
        pieces.add(new Piece(8));
        pieces.add(new Piece(7));
        Board board = new Board(pieces);

        Piece p = new Piece(Config.EmptyPiece);

        assertEquals(board.getEmptyPiece(), p);
    }

    @Test
    public void VerificaTabuleiroNaoResolvido() {
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(1));
        pieces.add(new Piece(2));
        pieces.add(new Piece(3));
        pieces.add(new Piece(4));
        pieces.add(new Piece(12));
        pieces.add(new Piece(13));
        pieces.add(new Piece(5));
        pieces.add(new Piece(14));
        pieces.add(new Piece(11));
        pieces.add(new Piece(Config.EmptyPiece));
        pieces.add(new Piece(15));
        pieces.add(new Piece(6));
        pieces.add(new Piece(10));
        pieces.add(new Piece(9));
        pieces.add(new Piece(8));
        pieces.add(new Piece(7));

        Board board = new Board(pieces);
        assertFalse(board.checkWin());
    }

    @Test
    public void VerificaTabuleiroResolvido() {
        Board _board = this.getTabuleiroResolvido();
        assertTrue(_board.checkWin());
    }

    @Test
    public void Row2Col1DeveRetornarZero() {
        Board _board = this.getTabuleiroResolvido();

        assertEquals(_board.getPieceAt(0, 0), new Piece(1));
        assertEquals(_board.getPieceAt(0, 1), new Piece(2));
        assertEquals(_board.getPieceAt(0, 2), new Piece(3));
        assertEquals(_board.getPieceAt(0, 3), new Piece(4));
        assertEquals(_board.getPieceAt(1, 0), new Piece(12));
        assertEquals(_board.getPieceAt(1, 1), new Piece(13));
        assertEquals(_board.getPieceAt(1, 2), new Piece(14));
        assertEquals(_board.getPieceAt(1, 3), new Piece(5));
        assertEquals(_board.getPieceAt(2, 0), new Piece(11));
        assertEquals(_board.getPieceAt(2, 1), new Piece(0));
        assertEquals(_board.getPieceAt(2, 2), new Piece(15));
        assertEquals(_board.getPieceAt(2, 3), new Piece(6));
        assertEquals(_board.getPieceAt(3, 0), new Piece(10));
        assertEquals(_board.getPieceAt(3, 1), new Piece(9));
        assertEquals(_board.getPieceAt(3, 2), new Piece(8));
        assertEquals(_board.getPieceAt(3, 3), new Piece(7));
    }

    @Test
    public void notSameBoardAfterPlay() {
        Board board = this.getTabuleiroResolvido();
        Board newBoard;
        boolean isError = false;
        try {
            newBoard = board.movePiece(EMovementType.DOWN);
            assertNotSame(newBoard, board);
        } catch (InvalidMovementException ex) {
            isError = true;
            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(isError);
    }

    @Test
    public void movePieceDown() {
        Board newBoard;
        boolean isError = false;
        try {
            newBoard = this.getTabuleiroResolvido().movePiece(EMovementType.DOWN);
            assertTrue(newBoard.getPieceAt(2, 1).getNumber() == 13);
        } catch (InvalidMovementException ex) {
            isError = true;
            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(isError);
    }

    @Test
    public void movePieceUp() {
        Board newBoard;
        boolean isError = false;
        try {
            newBoard = this.getTabuleiroResolvido().movePiece(EMovementType.UP);
            assertTrue(newBoard.getPieceAt(2, 1).getNumber() == 9);
        } catch (InvalidMovementException ex) {
            isError = true;
            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(isError);
    }

    @Test
    public void movePieceLeft() {
        Board newBoard;
        boolean isError = false;
        try {
            newBoard = this.getTabuleiroResolvido().movePiece(EMovementType.LEFT);
            assertTrue(newBoard.getPieceAt(2, 1).getNumber() == 15);
        } catch (InvalidMovementException ex) {
            isError = true;
            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(isError);
    }

    @Test
    public void movePieceRight() {
        Board newBoard;
        boolean isError = false;
        try {
            newBoard = this.getTabuleiroResolvido().movePiece(EMovementType.RIGHT);
            assertTrue(newBoard.getPieceAt(2, 1).getNumber() == 11);
        } catch (InvalidMovementException ex) {
            isError = true;
            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(isError);
    }

    @Test
    public void movePieceDownFail() {
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(Config.EmptyPiece));
        pieces.add(new Piece(1));
        pieces.add(new Piece(2));
        pieces.add(new Piece(3));
        pieces.add(new Piece(4));
        pieces.add(new Piece(12));
        pieces.add(new Piece(13));
        pieces.add(new Piece(14));
        pieces.add(new Piece(5));
        pieces.add(new Piece(11));
        pieces.add(new Piece(15));
        pieces.add(new Piece(6));
        pieces.add(new Piece(10));
        pieces.add(new Piece(9));
        pieces.add(new Piece(8));
        pieces.add(new Piece(7));

        Board board = new Board(pieces);
        boolean isError = false;
        try {
            board.movePiece(EMovementType.DOWN);
        } catch (InvalidMovementException ex) {
            isError = true;
        }

        assertTrue(isError);
    }

    @Test
    public void movePieceUpFail() {
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(1));
        pieces.add(new Piece(2));
        pieces.add(new Piece(3));
        pieces.add(new Piece(4));
        pieces.add(new Piece(12));
        pieces.add(new Piece(13));
        pieces.add(new Piece(14));
        pieces.add(new Piece(5));
        pieces.add(new Piece(11));
        pieces.add(new Piece(15));
        pieces.add(new Piece(6));
        pieces.add(new Piece(10));
        pieces.add(new Piece(9));
        pieces.add(new Piece(8));
        pieces.add(new Piece(7));
        pieces.add(new Piece(Config.EmptyPiece));

        Board board = new Board(pieces);
        boolean isError = false;
        try {
            board.movePiece(EMovementType.UP);
        } catch (InvalidMovementException ex) {
            isError = true;
        }

        assertTrue(isError);
    }

    @Test
    public void movePieceLeftFail() {
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(1));
        pieces.add(new Piece(2));
        pieces.add(new Piece(3));
        pieces.add(new Piece(4));
        pieces.add(new Piece(12));
        pieces.add(new Piece(13));
        pieces.add(new Piece(14));
        pieces.add(new Piece(5));
        pieces.add(new Piece(11));
        pieces.add(new Piece(15));
        pieces.add(new Piece(6));
        pieces.add(new Piece(10));
        pieces.add(new Piece(9));
        pieces.add(new Piece(8));
        pieces.add(new Piece(7));
        pieces.add(new Piece(Config.EmptyPiece));

        Board board = new Board(pieces);
        boolean isError = false;
        try {
            board.movePiece(EMovementType.LEFT);
        } catch (InvalidMovementException ex) {
            isError = true;
        }

        assertTrue(isError);
    }

    @Test
    public void movePieceRightFail() {
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(Config.EmptyPiece));
        pieces.add(new Piece(1));
        pieces.add(new Piece(2));
        pieces.add(new Piece(3));
        pieces.add(new Piece(4));
        pieces.add(new Piece(12));
        pieces.add(new Piece(13));
        pieces.add(new Piece(14));
        pieces.add(new Piece(5));
        pieces.add(new Piece(11));
        pieces.add(new Piece(15));
        pieces.add(new Piece(6));
        pieces.add(new Piece(10));
        pieces.add(new Piece(9));
        pieces.add(new Piece(8));
        pieces.add(new Piece(7));

        Board board = new Board(pieces);
        boolean isError = false;
        try {
            board.movePiece(EMovementType.RIGHT);
        } catch (InvalidMovementException ex) {
            isError = true;
        }

        assertTrue(isError);
    }
}
