package main.tests;
import main.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {

    private Player player;

    @BeforeEach
    public void setUp(){
        player = new Player("JDoe", 3, 1, 3, 2);
    }

    @Test
    public void testPlayer(){
        assertNotNull(player);

        assertEquals("JDoe", player.getUsername());
        assertEquals( 3, player.getNumberOfBulls());
        assertEquals( 1, player.getNumberOfCows());
        assertEquals(3, player.getCodesAttempted());
        assertEquals(2, player.getCodesDeciphered());
    }

    @Test
    public void testIncrementAttempts(){
        assertEquals(3, player.getCodesAttempted());
        player.incrementCodesAttempted();
        assertEquals(4, player.getCodesAttempted());
    }

    @Test
    public void testIncrementDeciphered(){
        assertEquals(2, player.getCodesDeciphered());
        player.incrementCodesDeciphered();
        player.incrementCodesDeciphered();
        assertEquals(4, player.getCodesDeciphered());
    }
}
