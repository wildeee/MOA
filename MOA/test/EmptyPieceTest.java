/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import moa.Config;
import moa.EmptyPiece;
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
 * @author guest-pEDpUc
 */
public class EmptyPieceTest {

    public EmptyPieceTest() {
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

    @After
    public void tearDown() {
    }

    @Test
    public void EmptyPieceTest() {
        int emptyNumber = Config.EmptyPiece;
        Position pos = new Position(1, 1);
        Piece emp = new EmptyPiece(pos, emptyNumber);

        assertEquals(emp.getPosition(), pos);
        assertEquals(emp.getNumber(), emptyNumber);
    }

    @Test
    public void PieceCloneTest() {
        Position pos = new Position(0, 0);
        Piece p = new EmptyPiece(pos, 0);

        Piece p2 = new EmptyPiece(p);

        assertNotSame(p, p2);
    }

}
