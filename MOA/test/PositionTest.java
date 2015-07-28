/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.security.InvalidParameterException;
import moa.Config;
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
public class PositionTest {

    public PositionTest() {
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
    public void testPosition() {
        Position pos = new Position(0, 0);
        assertEquals(pos.getX(), 0);
        assertEquals(pos.getY(), 0);
    }

    @Test
    public void testPositionInvlalidWidthNegative() {

        boolean isError = false;

        try {
            Position pos = new Position(-1, 0);
        } catch (InvalidParameterException ex) {
            isError = true;
        }

        assertTrue(isError);

    }

    @Test
    public void testPositionInvlalidWidthPositive() {

        boolean isError = false;

        try {
            Position pos = new Position(Config.BoardWidth + 1, 0);
        } catch (InvalidParameterException ex) {
            isError = true;
        }

        assertTrue(isError);

    }

    @Test
    public void testPositionInvlalidHeightNegative() {

        boolean isError = false;

        try {
            Position pos = new Position(0, -1);
        } catch (InvalidParameterException ex) {
            isError = true;
        }

        assertTrue(isError);

    }

    @Test
    public void testPositionInvlalidHeightPositive() {

        boolean isError = false;

        try {
            Position pos = new Position(0, Config.BoardHeight + 1);
        } catch (InvalidParameterException ex) {
            isError = true;
        }

        assertTrue(isError);

    }
}
