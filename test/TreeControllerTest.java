/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import moa.Board;
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

    private List<Piece> getPieces(String pieces) {
        List<Piece> p = new ArrayList<>();

        for (String strpiece : pieces.split(" ")) {
            p.add(new Piece(Integer.parseInt(strpiece)));
        }

        return p;
    }

    @Test
    public void tabuleiroResolvidoZeroJogadas() {

        List<Piece> pieces = this.getPieces("1 2 3 4 12 13 14 5 11 0 15 6 10 9 8 7");
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

    @Test
    public void testeExemploOitoJogadas() {

        List<Piece> pieces = this.getPieces("2 3 4 5 1 13 14 6 12 11 15 0 10 9 8 7");

        TreeController ctrl = new TreeController(
                new Root(
                        new Board(pieces)
                )
        );
        assertEquals(ctrl.calculateMinPlays(), 8);
    }

    @Test
    public void testeExemploTrezeJogadas() {

        List<Piece> pieces = this.getPieces("2 3 4 5 1 13 14 6 0 11 15 7 12 10 9 8");

        TreeController ctrl = new TreeController(
                new Root(
                        new Board(pieces)
                )
        );

        assertEquals(13, ctrl.calculateMinPlays());
    }

    @Test
    public void testeExemploVinteEOitoJogadas() {

        List<Piece> pieces = this.getPieces("2 4 5 6 0 3 14 13 1 11 9 7 12 15 10 8");

        TreeController ctrl = new TreeController(
                new Root(
                        new Board(pieces)
                )
        );

        assertEquals(28, ctrl.calculateMinPlays());
    }

    @Test
    public void testeExemploTrintaESeisJogadas() {

        List<Piece> pieces = this.getPieces("12 1 5 4 9 14 6 10 3 15 13 2 11 8 0 7");

        TreeController ctrl = new TreeController(
                new Root(
                        new Board(pieces)
                )
        );

        assertEquals(36, ctrl.calculateMinPlays());
    }

    @Test
    public void testeExemploQuarentaEUmaJogadas() {

        List<Piece> pieces = this.getPieces("0 4 6 13 2 5 3 7 1 11 14 8 12 15 9 10");

        TreeController ctrl = new TreeController(
                new Root(
                        new Board(pieces)
                )
        );

        assertEquals(41, ctrl.calculateMinPlays());
    }
//
//    @Test
//    public void testeExemploQuarentaESeisJogadas() {
//
//        List<Piece> pieces = this.getPieces("12 9 7 2 10 14 0 3 13 4 1 8 6 11 5 15");
//
//        TreeController ctrl = new TreeController(
//                new Root(
//                        new Board(pieces)
//                )
//        );
//
//        assertEquals(46, ctrl.calculateMinPlays());
//    }
//
//    @Test
//    public void testeExemploQuarentaEOitoJogadas() {
//
//        List<Piece> pieces = this.getPieces("14 13 7 8 5 2 15 3 12 6 4 9 10 1 0 11");
//
//        TreeController ctrl = new TreeController(
//                new Root(
//                        new Board(pieces)
//                )
//        );
//
//        assertEquals(48, ctrl.calculateMinPlays());
//    }
//
//    @Test
//    public void testeExemploInterrocagaoJogadas() {
//
//        List<Piece> pieces = this.getPieces("3 11 10 2 8 6 12 1 13 4 7 0 14 5 15 9");
//
//        TreeController ctrl = new TreeController(
//                new Root(
//                        new Board(pieces)
//                )
//        );
//        System.out.println(ctrl.calculateMinPlays());
//        //assertEquals(36, ctrl.calculateMinPlays());
//    }
}
