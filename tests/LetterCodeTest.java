package tests;

import main.LetterCode;
import main.NumbersCode;
import main.SecretCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class LetterCodeTest {

    SecretCode code;

    @BeforeEach
    public void setUp(){this.code = new LetterCode();}

    @Test
    public void testConstruct(){
        assertEquals(LetterCode.class, code.getClass());
        assertNotEquals(NumbersCode.class, code.getClass());
        assertNotEquals(SecretCode.class, code.getClass());
    }

    @Test
    public void testGetSecretLetterCode(){
        assertNotEquals(null, code.getSecretCode());
    }

    @Test
    public void testSecretCodeValid(){
        for (int i = 0; i < 100; i++) {
            assertEquals(4, code.getSecretCode().length());

            char[] code_char_arr = code.getSecretCode().toCharArray();

            Set<Character> setCheck = new HashSet<>();
            setCheck.add(code_char_arr[0]);
            setCheck.add(code_char_arr[1]);
            setCheck.add(code_char_arr[2]);
            setCheck.add(code_char_arr[3]);
            assertEquals(4, setCheck.size());

            code.getCode();
        }
    }
}
