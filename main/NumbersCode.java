package main;

import java.util.*;

public class NumbersCode extends SecretCode{

    private String secretCode;

    public NumbersCode() {
    }

    public NumbersCode(String code) {
        setSecretCode(code);
    }

    @Override
    public void getCode() {
        ArrayList<Integer> digits = new ArrayList<>();
        for(int i=0; i<10; i++)
            digits.add(i);
        Collections.shuffle(digits);
        StringBuilder secretCode = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            secretCode.append(digits.get(i));
        }
        this.secretCode = secretCode.toString();
    }

    public String getSecretCode() {
        if(this.secretCode==null){
            this.getCode();
        }else if(this.secretCode.length() != 10)
            this.getCode();
        return  this.secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    @Override
    public String toString(){
        return String.valueOf(this.secretCode);
    }
}