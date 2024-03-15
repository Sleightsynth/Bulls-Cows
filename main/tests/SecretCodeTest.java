package main.tests;

import main.SecretCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecretCodeTest {

    SecretCode secretCode;
    @BeforeEach
    public void setUp(){
        this.secretCode = new SecretCode();
    }

    @Test
    void setDecipheredCode() {
        this.secretCode.setDecipheredCode(true);
        assertTrue(this.secretCode.isDecipheredCode());
    }

    @Test
    void isDecipheredCode() {
        assertFalse(this.secretCode.isDecipheredCode());
    }
}