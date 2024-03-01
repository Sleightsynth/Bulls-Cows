package tests;

import main.LetterCode;
import main.NumbersCode;
import main.SecretCode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class NumberCodeTest {


    @Test
    public void testConstruct(){
        SecretCode code = new NumbersCode();
        assertEquals(NumbersCode.class, code.getClass());
        assertNotEquals(LetterCode.class, code.getClass());
        assertNotEquals(SecretCode.class, code.getClass());
    }

    @Test
    public void testGetSecretCode(){

        NumbersCode code = new NumbersCode();
        assertNotEquals(0, code.getSecretCode());
    }

    @Test
    public void testSecretCodeValid(){
        NumbersCode code = new NumbersCode();
        for (int i = 0; i < 100; i++) {
            assertTrue(
                    code.getSecretCode() > 999 &&
                    code.getSecretCode() < 10000
            );

            char[] code_char_arr = String.valueOf(code.getSecretCode()).toCharArray();


            Set<Character> setCheck = new HashSet();
            setCheck.add(code_char_arr[0]);
            setCheck.add(code_char_arr[1]);
            setCheck.add(code_char_arr[2]);
            setCheck.add(code_char_arr[3]);
            assertEquals(4, setCheck.size());

            code.getCode();
        }
    }
}
