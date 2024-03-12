package main;

public class SecretCode {
    private boolean decipheredCode;

    private String secretCode;

    public SecretCode(){
        this.decipheredCode = false;
    }

    public SecretCode(String secretCode) {
        this.decipheredCode = false;
        this.secretCode = secretCode;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public void setDecipheredCode(boolean deciphered)
    {
        this.decipheredCode = deciphered;
    }

    public boolean isDecipheredCode() {
        return decipheredCode;
    }

    public void getCode(){
    }

    @Override
    public String toString() {
        return this.secretCode;
    }
}
