/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import moa.Board;
import moa.Config;
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

    Board board;

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
        List<Piece> lista = new ArrayList<>();
        int count = Config.EmptyPiece;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                lista.add(new Piece(count));
            }
        }
        board = new Board(lista);
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
        Piece p = new Piece(Config.EmptyPiece);
        assertEquals(board.getEmptyPiece(), p);
    }

    @Test
    public void VerificaTabuleiroNaoResolvido() {
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
}
