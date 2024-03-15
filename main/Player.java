package main;

import java.io.Serial;
import java.io.Serializable;

public class Player implements Serializable {

    // ATTRIBUTES
    // ----------
    @Serial
    private static final long serialVersionUID = 645214280240932938L;
    private String username;

    private int numberOfBulls, numberOfCows, codesAttempted, codesDeciphered;

    // CONSTRUCTORS
    // ------------

    public Player() {
    }

    public Player(String username) {
        this.username = username;
    }

    public Player(
            String username, int numberOfBulls, int numberOfCows, int codesAttempted, int codesDeciphered
    ) {
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
    
    //public void setCodesDeciphered(int codesDeciphered) {this.codesDeciphered = codesDeciphered;}

    //public void setCodesAttempted(int codesAttempted) {this.codesAttempted = codesAttempted;}

    // METHODS
    // -------

    public void incrementCodesDeciphered(){
        ++this.codesDeciphered;
    }

    public void incrementCodesAttempted(){
    ++this.codesAttempted;
    }

    @Override
    public String toString(){
        return this.username;
    }

    private double getPercent() {

        return ((double) this.codesDeciphered / this.codesAttempted)*100;
    }

    public String getStats(){
        return String.format(
                """
                Number of Codes Attempted   :   %s
                Number of Codes Deciphered  :   %s
                Percentage of Success       :   %.2f%%
                    """,
                this.codesAttempted, this.codesDeciphered, getPercent()
        );
    }

}