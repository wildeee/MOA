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

        Board b2, b3, b4, b5;
        b2 = board.movePiece(EMovementType.DOWN);
        b3 = board.movePiece(EMovementType.LEFT);
        b4 = b2.movePiece(EMovementType.UP);
        b5 = b3.movePiece(EMovementType.LEFT);

        Branch br2, br3, br4, br5;
        br2 = new Branch(b2, root);
        br3 = new Branch(b3, root);
        br4 = new Branch(b4, br2);
        br5 = new Branch(b5, br3);

        String hash1 = prior.remove().getBoard().getHash();
        assertEquals(board.getHash(), hash1);

        List<Branch> branchList = new ArrayList<>();
        branchList.add(br2);
        branchList.add(br3);
        branchList.add(br4);
        branchList.add(br5);
        prior.add(branchList);

        String hash2 = prior.remove().getBoard().getHash();
        String hash3 = prior.remove().getBoard().getHash();
        String hash4 = prior.remove().getBoard().getHash();
        String hash5 = prior.remove().getBoard().getHash();

        assertEquals(b4.getHash(), hash2);
        assertEquals(b2.getHash(), hash3);
        assertEquals(b3.getHash(), hash4);
        assertEquals(b5.getHash(), hash5);

    }

}
