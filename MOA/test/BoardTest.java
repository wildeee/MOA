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
import moa.Position;
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
                lista.add(new Piece(new Position(i, j), count));
            }
        }
        board = new Board(lista);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void PegaPecaVazia() {
        Position pos = new Position(3, 3);
        Piece p = new Piece(pos, Config.EmptyPiece);
        assertEquals(board.getEmptyPiece(), p);
    }
    
    @Test
    public void VerificaTabuleiroNaoResolvido(){
        assertFalse(board.checkWin());
    }
    
    @Test
    public void VerificaTabuleiroResolvido(){
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(new Position(0, 0), 1));
        pieces.add(new Piece(new Position(0, 1), 2));
        pieces.add(new Piece(new Position(0, 2), 3));
        pieces.add(new Piece(new Position(0, 3), 4));
        pieces.add(new Piece(new Position(1, 0), 12));
        pieces.add(new Piece(new Position(1, 1), 13));
        pieces.add(new Piece(new Position(1, 2), 14));
        pieces.add(new Piece(new Position(1, 3), 5));
        pieces.add(new Piece(new Position(2, 0), 11));
        pieces.add(new Piece(new Position(2, 1), Config.EmptyPiece));
        pieces.add(new Piece(new Position(2, 2), 15));
        pieces.add(new Piece(new Position(2, 3), 6));
        pieces.add(new Piece(new Position(3, 0), 10));
        pieces.add(new Piece(new Position(3, 1), 9));
        pieces.add(new Piece(new Position(3, 2), 8));
        pieces.add(new Piece(new Position(3, 3), 7));
        
        
        
        Board _board = new Board(pieces);
        assertTrue(_board.checkWin());
    }
}
