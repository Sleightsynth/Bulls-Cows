package tests;
import main.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {
    @Test
    public void testPlayer(){
        Player player = new Player();
        assertNotNull(player);
        assertNull(player.getUsername());
        assertEquals( 0, player.getNumberOfBulls());
        assertEquals( 0, player.getNumberOfCows());
        assertEquals(0, player.getCodesAttempted());
        assertEquals(0, player.getCodesDeciphered());

        player.setUsername("JDoe");
        player.setCodesAttempted(3);
        player.setCodesDeciphered(1);
        player.setNumberOfBulls(3);
        player.setNumberOfCows(2);

        assertEquals("JDoe", player.getUsername());
        assertEquals(3, player.getCodesAttempted());
        assertEquals(1, player.getCodesDeciphered());
        assertEquals( 3, player.getNumberOfBulls());
        assertEquals( 2, player.getNumberOfCows());

        player.incrementCodesAttempted();
        player.incrementCodesDeciphered();
        player.incrementCodesDeciphered();

        assertEquals(4, player.getCodesAttempted());
        assertEquals(3, player.getCodesDeciphered());
    }

}
