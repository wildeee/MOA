/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class NormalPieceTest {

    public NormalPieceTest() {
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
    public void NormalPieceCtrTest() {
        Position pos = new Position(0, 0);
        Piece p = new Piece(pos, 1);

        assertEquals(p.getPosition(), pos);
        assertEquals(p.getNumber(), 1);
    }

    @Test
    public void PieceCloneTest() {
        Position pos = new Position(0, 0);
        Piece p = new Piece(pos, 0);

        Piece p2 = new Piece(p);

        assertNotSame(p, p2);
    }
}
