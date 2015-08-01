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
import moa.Root;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {

    public NodeTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void VerificaNodeFilhoGerado() {

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

        Root r = new Root(new Board(pieces));

        try {
            Branch br = new Branch(r.getBoard().movePiece(EMovementType.DOWN), r);

            assertNotSame(r.getBoard().getPieceAt(2, 3), br.getBoard().getPieceAt(2, 3));
        } catch (InvalidMovementException ex) {
            throw new AssertionError();
        }

    }
}
