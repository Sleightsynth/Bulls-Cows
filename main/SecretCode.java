package main;

public class SecretCode {
    private boolean decipheredCode;

    private String secretCode;

    public SecretCode(){
        this.decipheredCode = false;
    }

    public String getSecretCode() {
        return secretCode;
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
}
