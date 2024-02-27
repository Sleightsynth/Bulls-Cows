package main;

import java.util.Random;

public class NumbersCode implements SecretCode{

    private boolean decipheredCode;
    private int code;



    NumbersCode() {
        this.decipheredCode = false;
        Random ran = new Random();
        this.code = ran.nextInt(999,9999);
    }

    public void setDecipheredCode(boolean deciphered)
    {
        this.decipheredCode = deciphered;
    }

    public int getCode() {
        return this.code;
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.code);
    }

}