package tests;
import main.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTests {
    @Test
    public void testPlayer(){
        Player player = new Player();
        assertNotNull(player);
    }

}
