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
- [ ] Given there are words stored - Andy
- [ ] When the player requests a secret code
- [ ] Then a secret code representing an English word is returned and number of secret code attempts is updated.

Scenario: Player requests numbers secret code
- [x] Given the player has opened the program
- [x] When the player requests a secret code
- [x] Then a secret code is generated representing a sequence of unique numbers and number of secret code attempts is updated. 

Scenario: Player requests a letters secret code but no phrases file exists - Andy
- [ ] Given there are no words stored
- [ ] When the player requests a secret code
- [ ] Then an error message is shown and the game exits

2. As a player I want to be able to enter a guess so I can decipher the secret code.

Scenario: player enters a guess ANDY
- [ ] Given a secret code is displayed 
- [ ] When the player enters a guess 
- [ ] Then the number of bulls and cows are displayed and the player stats are updated 

Scenario: player enters the correct guess and successfully deciphers the code- ANDY
- [ ] Given a secret code is displayed  
- [ ] When the player enters the correct guess 
- [ ] Then a success message is displayed, their stats are updated and the game is finished

Scenario: player enters a guess with an invalid length - ANDY
- [x] Given a secret code is displayed  
- [x] When the player enters a guess with an invalid length 
- [x] Then an error message is displayed and they are asked to try again

Scenario: player enters an invalid guess for a letters code - ANDY 
- [ ] Given a secret code is displayed  
- [ ] When the player enters a guess containing numbers 
- [ ] Then an error message is displayed and they are asked to try again 

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
- [ ] Given a secret code is displayed and a guess hasn’t already been entered
- [ ] When a player selects a letter/number to replace
- [ ] Then an error message is displayed to the player indicating a complete guess hasn’t been made yet

Scenario: player wants to undo an invalid letter/number in the guess
- [ ] Given a secret code is displayed and a guess has already been entered
- [ ] When a player selects an invalid letter/number to replace
- [ ] Then an error message is displayed and they are asked to try again

