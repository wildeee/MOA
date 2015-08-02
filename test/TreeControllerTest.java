/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import moa.Board;
import moa.Branch;
import moa.EMovementType;
import moa.InvalidMovementException;
import moa.Piece;
import moa.Root;
import moa.TreeController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guest-rc7n4B
 */
public class TreeControllerTest {

    public TreeControllerTest() {
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
    public void testeExemploOitoJogadas() {

        List<Piece> pieces = new ArrayList<>();

        pieces.add(new Piece(2));
        pieces.add(new Piece(3));
        pieces.add(new Piece(4));
        pieces.add(new Piece(5));

        pieces.add(new Piece(1));
        pieces.add(new Piece(13));
        pieces.add(new Piece(14));
        pieces.add(new Piece(6));

        pieces.add(new Piece(12));
        pieces.add(new Piece(11));
        pieces.add(new Piece(15));
        pieces.add(new Piece(0));

        pieces.add(new Piece(10));
        pieces.add(new Piece(9));
        pieces.add(new Piece(8));
        pieces.add(new Piece(7));

        TreeController ctrl = new TreeController(
                new Root(
                        new Board(pieces)
                )
        );
        assertEquals(ctrl.calculateMinPlays(), 8);
    }

    @Test
    public void testeExemploTrezeJogadas() {

        List<Piece> pieces = new ArrayList<>();

        pieces.add(new Piece(2));
        pieces.add(new Piece(3));
        pieces.add(new Piece(4));
        pieces.add(new Piece(5));

        pieces.add(new Piece(1));
        pieces.add(new Piece(13));
        pieces.add(new Piece(14));
        pieces.add(new Piece(6));

        pieces.add(new Piece(0));
        pieces.add(new Piece(11));
        pieces.add(new Piece(15));
        pieces.add(new Piece(7));

        pieces.add(new Piece(12));
        pieces.add(new Piece(10));
        pieces.add(new Piece(9));
        pieces.add(new Piece(8));

        TreeController ctrl = new TreeController(
                new Root(
                        new Board(pieces)
                )
        );

        assertEquals(13, ctrl.calculateMinPlays());
    }

    @Test
    public void testeExemploTrintaJogadas() {

        List<Piece> pieces = new ArrayList<>();

        pieces.add(new Piece(2));
        pieces.add(new Piece(4));
        pieces.add(new Piece(5));
        pieces.add(new Piece(6));

        pieces.add(new Piece(0));
        pieces.add(new Piece(3));
        pieces.add(new Piece(14));
        pieces.add(new Piece(13));

        pieces.add(new Piece(1));
        pieces.add(new Piece(11));
        pieces.add(new Piece(9));
        pieces.add(new Piece(7));

        pieces.add(new Piece(12));
        pieces.add(new Piece(15));
        pieces.add(new Piece(10));
        pieces.add(new Piece(8));

        TreeController ctrl = new TreeController(
                new Root(
                        new Board(pieces)
                )
        );

        //assertEquals(30, ctrl.calculateMinPlays());
    }

    @Test
    public void tabuleiroResolvidoZeroJogadas() {
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
        pieces.add(new Piece(0));
        pieces.add(new Piece(15));
        pieces.add(new Piece(6));

        pieces.add(new Piece(10));
        pieces.add(new Piece(9));
        pieces.add(new Piece(8));
        pieces.add(new Piece(7));

        Board board = new Board(pieces);
        Root root = new Root(board);
        TreeController ctrl = new TreeController(root);
        assertEquals(ctrl.calculateMinPlays(), 0);
    }
}
