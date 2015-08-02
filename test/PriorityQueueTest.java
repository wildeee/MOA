/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import moa.Board;
import moa.Branch;
import moa.EMovementType;
import moa.InvalidMovementException;
import moa.Piece;
import moa.PriorityQueue;
import moa.Root;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class PriorityQueueTest {

    public PriorityQueueTest() {
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
    public void testPriorityInsertionMaisPrioritarioInserido() throws InvalidMovementException {
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
        PriorityQueue prior = new PriorityQueue(root);
        Board b2;
        Board b3;
        b2 = board.movePiece(EMovementType.LEFT);
        b3 = b2.movePiece(EMovementType.UP);

        List<Branch> branchList = new ArrayList<>();
        branchList.add(new Branch(b2, root));
        branchList.add(new Branch(b3, root));
        prior.add(branchList);
        String hash1 = prior.remove().getBoard().getHash();
        String hash2 = prior.remove().getBoard().getHash();
        String hash3 = prior.remove().getBoard().getHash();
        assertEquals(board.getHash(), hash1);
        assertEquals(b2.getHash(), hash2);
        assertEquals(b3.getHash(), hash3);

    }

    @Test
    public void testPriorityInsertionMenosPrioritarioInserido() throws InvalidMovementException {

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
        PriorityQueue prior = new PriorityQueue(root);
        Board b2;
        Board b3;
        b2 = board.movePiece(EMovementType.LEFT);
        b3 = b2.movePiece(EMovementType.RIGHT);

        List<Branch> branchList = new ArrayList<>();
        branchList.add(new Branch(b2, root));
        branchList.add(new Branch(b3, root));
        prior.add(branchList);
        String hash1 = prior.remove().getBoard().getHash();
        String hash2 = prior.remove().getBoard().getHash();
        String hash3 = prior.remove().getBoard().getHash();
        assertEquals(board.getHash(), hash1);
        assertEquals(b3.getHash(), hash2);
        assertEquals(b2.getHash(), hash3);

//        List<Piece> pieces = new ArrayList<>();
//        pieces.add(new Piece(1));
//        pieces.add(new Piece(2));
//        pieces.add(new Piece(3));
//        pieces.add(new Piece(4));
//
//        pieces.add(new Piece(12));
//        pieces.add(new Piece(13));
//        pieces.add(new Piece(14));
//        pieces.add(new Piece(5));
//
//        pieces.add(new Piece(11));
//        pieces.add(new Piece(0));
//        pieces.add(new Piece(15));
//        pieces.add(new Piece(6));
//
//        pieces.add(new Piece(10));
//        pieces.add(new Piece(9));
//        pieces.add(new Piece(8));
//        pieces.add(new Piece(7));
//
//        Board board = new Board(pieces);
//        Root root = new Root(board);
//        PriorityQueue prior = new PriorityQueue(root);
//        Board b2;
//        b2 = board.movePiece(EMovementType.LEFT);
//        Branch br = new Branch(b2, root);
//        prior.add(br);
//        String hash = prior.remove().getBoard().getHash();
//        assertEquals(root.getBoard().getHash(), hash);
    }

}
