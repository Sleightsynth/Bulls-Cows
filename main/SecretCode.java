package main;

public class SecretCode {
    private boolean decipheredCode;

    public SecretCode(){
        this.decipheredCode = false;
    }

    public void setDecipheredCode(boolean deciphered)
    {
        this.decipheredCode = deciphered;
    }

    public boolean isDecipheredCode() {
        return decipheredCode;
    }
}
