package main;

public class Player {
    
    // ATTRIBUTES
    // ----------

    private String username;
    
    private int numberOfBulls, numberOfCows, codesAttempted, codesDeciphered;

    // CONSTRUCTERS
    // ------------
    
    public Player(){}

    public Player(
        String username, int numberOfBulls, int numberOfCows, int codesAttempted, int codesDeciphered
    ){
        this.username = username;
        this.numberOfBulls = numberOfBulls;
        this.numberOfCows = numberOfCows;
        this.codesAttempted = codesAttempted;
        this.codesDeciphered = codesDeciphered;
    }

    // GETTERS
    // -------

    public String getUsername() {
        return username;
    }

    public int getNumberOfBulls() {
        return numberOfBulls;
    }
    
    public int getNumberOfCows() {
        return numberOfCows;
    }
    
    public int getCodesDeciphered() {
        return codesDeciphered;
    }
    
    public int getCodesAttempted() {
        return codesAttempted;
    }

    // SETTERS
    // -------

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNumberOfBulls(int numberOfBulls) {
        this.numberOfBulls = numberOfBulls;
    }

    public void setNumberOfCows(int numberOfCows) {
        this.numberOfCows = numberOfCows;
    }
    
    public void setCodesDeciphered(int codesDeciphered) {
        this.codesDeciphered = codesDeciphered;
    }

    public void setCodesAttempted(int codesAttempted) {
        this.codesAttempted = codesAttempted;
    }

    // METHODS
    // -------

    public void incrementCodesDeciphered(){
        ++this.codesDeciphered;
    }

    public void incrementCodesAttempted(){
    ++this.codesAttempted;
    }



}
