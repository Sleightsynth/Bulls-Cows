package main.tests;

import main.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Player player;
    private Game game;


    @BeforeEach
    void setUp() {
        this.player = new Player("John", 2, 2, 5, 3);
        this.game = new Game(new Players(), this.player, new SecretCode("test"));

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void loadPlayerTest() {
        assertEquals(this.player, game.loadPlayer());
    }

    @Test
    public void requestCodeTest() {
        this.game.requestCode("letter");
        assertEquals(LetterCode.class, this.game.getCurrentCode().getClass());
        this.game.requestCode("number");
        assertEquals(NumbersCode.class, this.game.getCurrentCode().getClass());
    }

    @Test
    public void makeNumberGuessTest() {
        game.requestCode("number");
        assertFalse(game.enterGuess("12d3"));
        assertFalse(game.enterGuess("123"));
        assertFalse(game.enterGuess("12345"));
        assertTrue(game.enterGuess("1234"));
        assertEquals("1234", game.getGuess());
    }

    @Test
    public void makeLetterGuessTest() {
        game.setCurrentCode(new LetterCode());
        assertFalse(game.enterGuess("12d3"));
        assertFalse(game.enterGuess("asdfg"));
        assertFalse(game.enterGuess("as"));
        assertTrue(game.enterGuess("abcd"));
        assertEquals("abcd", game.getGuess());
    }

    @Test
    public void undoGuessTest() {
        game.setGuess("1234");
        assertEquals("1234", game.getGuess());
        game.undoGuess("y");
        assertEquals("1234", game.getGuess());
        game.undoGuess("n");
        assertNotEquals("1234", game.getGuess());
    }

    @Test
    public void checkGuessTest() {

    }

    @Test
    public void requestLetterCode() {
        game.requestCode("letter");
        assertEquals(LetterCode.class, game.getCurrentCode().getClass());
    }

    @Test
    public void requestNumbersCode() {
        game.requestCode("number");
        assertEquals(NumbersCode.class, game.getCurrentCode().getClass());
    }

    @Test
    public void incrementLetterCode() {
        assertEquals(5, player.getCodesAttempted());
        game.requestCode("letter");
        assertEquals(6, player.getCodesAttempted());
    }

    @Test
    public void incrementNumberCode() {
        assertEquals(5, player.getCodesAttempted());
        game.requestCode("number");
        assertEquals(6, player.getCodesAttempted());
    }
    @Test
    public void incrementDecipheredCode() {
        assertEquals(3, player.getCodesDeciphered());
        game.checkGuess("test");
        assertEquals(4, player.getCodesDeciphered());
    }

    @Test
    public void testShowSolution() {
        game.setCurrentCode(new LetterCode("abcd"));
        assertEquals("abcd", game.showSolution().getSecretCode());
    }

    @Test
    public void testSaveGame() {
        game.setCurrentCode(new NumbersCode("1234"));
        game.saveGame();
        game.loadGame();
        assertEquals("1234",game.showSolution().getSecretCode());
    }

    @Test
    public void testLoadGame() {
        player.setUsername("Alice");
        game.setCurrentCode(new LetterCode("abcd"));
        game.saveGame();
        game.loadGame();
        assertNotNull(game.getCurrentCode());
        assertEquals("abcd", game.getCurrentCode().toString());
    }

    @Test
    public void testGetHint() {
        game.setCurrentCode(new LetterCode("abcd"));
        game.getHint();
        String hint = game.loadPlayer().getStats();
        assertNotNull(hint);
        assertNotEquals("", hint);
        assertTrue(hint.matches("There is a '[a-z]' at position [1-4]"));
    }
}

// Scenario 1: Player requests letters secret code
//    @Test
//    public void testRequestLetters() {
//        // Given
//        // todo: ?? what is setWords? would this not be just to make a new code with these values?
//        game.setWords(new String[]{"soul", "bald", "orange"});
//
//        // When
//        String secretCode = game.requestCode(true);
//
//        // Then
//        assertNotNull(secretCode);
//        assertTrue(secretCode.matches("[a-zA-Z]+"));
//        assertEquals(1, player.getCodesAttempted());
//    }

// Scenario 2: Player requests numbers secret code
//    @Test
//    public void testRequestNumbers() {
//        // When
//        String secretCode = game.requestCode(false);
//
//        // Then
//        assertNotNull(secretCode);
//        assertTrue(secretCode.matches("\\d+"));
//        assertEquals(1, player.getCodesAttempted());
//    }

// Scenario 3: Player requests letters secret code but no phrases file exists
//    @Test
//    public void testRequestLettersNoFile() {
//        // Given
//        game.setWords(new String[]{});
//
//        // When
//        String errorMessage = game.requestCode(true);
//
//        // Then
//        assertEquals("Error: No words available. Exiting the game.", errorMessage);
//    }

// Scenario 4: Player enters a guess
//    @Test
//    public void testPlayerEntersGuess() {
//        // Given
//        game.setWords("bald");
//
//        // When
//        String result = game.enterGuess("balb");
//
//        // Then
//        assertEquals("Bulls: 3, Cows: 1", result);
//        assertEquals(1, player.getCodesAttempted());
//    }

// Scenario 5: Player enters the correct guess and successfully deciphers the code
//    @Test
//    public void testPlayerEntersCorrectGuess() {
//        // Given
//        game.setWords("bald");
//
//        // When
//        String result = game.enterGuess("bald");
//
//        // Then
//        assertEquals("Congratulations! You've successfully deciphered the code.", result);
//        assertEquals(1,player.getCodesDeciphered());
//    }

// Scenario 6: Player enters a guess with an invalid length
//    @Test
//    public void testInvalidLengthGuess() {
//        // Given
//        game.setWords("bald");
//
//        // When
//        String errorMessage = game.enterGuess("ba");
//
//        // Then
//        assertEquals("Error: Invalid guess length. Please try again.", errorMessage);
//    }

// Scenario 7: Player enters an invalid guess for a letters code
//    @Test
//    public void testInvalidLettersGuess() {
//        // Given
//        game.setWords("bald");
//
//        // When
//        String errorMessage = game.enterGuess("1234");
//
//        // Then
//        assertEquals("Error: Invalid guess. Guess should only contain letters.", errorMessage);
//    }
//
//    // Scenario 8: Player enters an invalid guess for a numbers code
//    @Test
//    public void testInvalidNumbersGuess() {
//        // Given
//        game.setWords("1234");
//
//        // When
//        String errorMessage = game.enterGuess("bald");
//
//        // Then
//        assertEquals("Error: Invalid guess. Guess should only contain numbers.", errorMessage);
//    }
//
//    // Scenario 9: Player wants to undo a single letter/number in the guess
//    @Test
//    public void testUndoSingleLetterOrNumber() {
//        // Given
//        game.setWords("bald");
//        game.enterGuess("balb");
//
//        // When
//        String updatedGuess = game.undoGuess('b');
//
//        // Then
//        assertEquals("bal", updatedGuess);
//    }
//
//    // Scenario 10: Player wants to undo a single letter/number in the guess when the player hasn’t guessed yet
//    @Test
//    public void testUndoSingleLetterOrNumberNoGuessYet() {
//        // Given
//        game.setWords("bald");
//
//        // When
//        String errorMessage = game.undoGuess('d');
//
//        // Then
//        assertEquals("Error: No guess made yet. Please make a guess first.", errorMessage);
//    }
//
//    // Scenario 11: Player wants to undo an invalid letter/number in the guess
//    @Test
//    public void testUndoInvalidLetterOrNumber() {
//        // Given
//        game.setWords("bald");
//        game.enterGuess("balb");
//
//        // When
//        String errorMessage = game.undoGuess('z');
//
//        // Then
//        assertEquals("Error: Invalid letter/number to undo. Please try again.", errorMessage);
//    }