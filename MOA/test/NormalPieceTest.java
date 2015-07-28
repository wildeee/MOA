/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        Piece p = new Piece(1);
        assertEquals(p.getNumber(), 1);
    }

    @Test
    public void PieceCloneTest() {
        Piece p = new Piece(0);

        Piece p2 = new Piece(p);

        assertNotSame(p, p2);
    }
}
