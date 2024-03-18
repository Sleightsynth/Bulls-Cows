# CS207 Group 5 - Bulls and Cows

Welcome to the CS207 Group 5 Git Repository for the Bulls and Cows Assignment!

# Members:

- James Park
- Robert Nairn
- Sean McIlroy
- Shaun Dempsey
- Stuart Gordon

## Sprint One

1. As a player I want to be able to request a secret code so I can try to decipher it.

Scenario: Player requests letters secret code
- [x] Given there are words stored - Andy
- [x] When the player requests a secret code
- [x] Then a secret code representing an English word is returned and number of secret code attempts is updated.
- [x] Given there are words stored - Andy
- [x] When the player requests a secret code
- [x] Then a secret code representing an English word is returned and number of secret code attempts is updated.

Scenario: Player requests numbers secret code
- [x] Given the player has opened the program
- [x] When the player requests a secret code
- [x] Then a secret code is generated representing a sequence of unique numbers and number of secret code attempts is updated.
- [x] Then a secret code is generated representing a sequence of unique numbers and number of secret code attempts is updated.

Scenario: Player requests a letters secret code but no phrases file exists - Andy
- [x] Given there are no words stored
- [x] When the player requests a secret code
- [x] Then an error message is shown and the game exits

2. As a player I want to be able to enter a guess so I can decipher the secret code.

Scenario: player enters a guess ANDY
- [x] Given a secret code is displayed 
- [x] When the player enters a guess 
- [x] Then the number of bulls and cows are displayed and the player stats are updated 

Scenario: player enters the correct guess and successfully deciphers the code- ANDY
- [x] Given a secret code is displayed  
- [x] When the player enters the correct guess 
- [x] Then a success message is displayed, their stats are updated and the game is finished

Scenario: player enters a guess with an invalid length - ANDY
- [x] Given a secret code is displayed  
- [x] When the player enters a guess with an invalid length 
- [x] Then an error message is displayed and they are asked to try again

Scenario: player enters an invalid guess for a letters code - ANDY 
- [x] Given a secret code is displayed  
- [x] When the player enters a guess containing numbers 
- [x] Then an error message is displayed and they are asked to try again 

Scenario: player enters an invalid guess for a numbers code - JAMES
- [x] Given a secret code is displayed  
- [x] When the player enters a guess containing letters 
- [x] Given a secret code is displayed
- [x] When the player enters a guess
- [x] Then the number of bulls and cows are displayed and the player stats are updated

Scenario: player enters the correct guess and successfully deciphers the code- ANDY
- [x] Given a secret code is displayed
- [x] When the player enters the correct guess
- [x] Then a success message is displayed, their stats are updated and the game is finished

Scenario: player enters a guess with an invalid length - ANDY
- [x] Given a secret code is displayed
- [x] When the player enters a guess with an invalid length
- [x] Then an error message is displayed and they are asked to try again

Scenario: player enters an invalid guess for a letters code - ANDY
- [x] Given a secret code is displayed
- [x] When the player enters a guess containing numbers
- [x] Then an error message is displayed and they are asked to try again

Scenario: player enters an invalid guess for a numbers code - JAMES
- [x] Given a secret code is displayed
- [x] When the player enters a guess containing letters
- [x] Then an error message is displayed and they are asked to try again

3. As a player I want to be able to undo a letter/number so I can try to decipher the secret code.

Scenario: player wants to undo a single letter/number in the guess - JAMES SEAN STUART
- [x] Given a secret code is displayed and a guess has already been entered
- [x] When a player selects a letter/number to replace
- [x] Then the letter/number is replaced in the guess and the number of bulls and cows updated

Scenario: player wants to undo a single letter/number in the guess when the player hasn’t guessed yet
- [x] Given a secret code is displayed and a guess hasn’t already been entered
- [x] When a player selects a letter/number to replace
- [x] Then an error message is displayed to the player indicating a complete guess hasn’t been made yet

Scenario: player wants to undo an invalid letter/number in the guess
- [x] Given a secret code is displayed and a guess has already been entered
- [x] When a player selects an invalid letter/number to replace
- [x] Then an error message is displayed and they are asked to try again

## Sprint Two

4. As a player I want to be able to save a secret code so I can try to decipher it at another time - Stuart


5. As a player I want to be able to load a secret code so I can continue trying to decipher a saved secret code - Stuart


7. As a player I want to store my player name so the software can track my game play statistics - Shaun, Andy


8. As a player I want the software to track the number of secret codes I have successfully deciphered - Sean


9. As a player I want the software to track the number of secret codes I have attempted to decipher so I can see how many I’ve attempted - Sean


10. As a player I want the software to track the number of bulls and cows I have guessed so I can see how accurate I am as a percentage of my total number of guesses - Shaun, Andy


11. As a player I want to display my game play statistics so I can see my performance - Shaun, Andy


12. As a player I want to load my details so I can track my game play statistics - James


NOTE - for the purpose of marking, store my player name and tracking the secret codes deciphered, attempted and correct guesses will be counted as a single user story

## Sprint Three

6. As a player I want to be able to show the solution so I can see a deciphered secret code for a code I can’t decipher


12. As a player I want to be able to see the top 10 scores for number of successfully deciphered codes so I can see what I need to score to be within the top 10


14. As a player I want to be able to get a hint for a letter/number so I can decipher the secret code


NOTE - The customer has now decided they would like the secret codes to be of length 10. You will need to update your code and test to handle this.


>>>>>>> main