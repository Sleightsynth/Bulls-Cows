package main;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumbersCode extends SecretCode{


    private int secretCode;

    public NumbersCode() {
    }

    @Override
    public void getCode() {
        Random random = new Random();

        do {
            Set<Integer> usedDigits = new HashSet<>();
            int[] codeArray = new int[4];

            for (int i = 0; i < codeArray.length; i++) {
                int nextDigit;
                do {
                    nextDigit = random.nextInt(10);
                } while (usedDigits.contains(nextDigit));

                usedDigits.add(nextDigit);
                codeArray[i] = nextDigit;
            }

            this.secretCode = codeArray[0] * 1000 + codeArray[1] * 100 + codeArray[2] * 10 + codeArray[3];
        } while (this.secretCode < 1000);
    }

    public int getSecretCode() {
        if(this.secretCode == 0)
            this.getCode();
        return this.secretCode;
    }

    public void setSecretCode(int secretCode) {
        this.secretCode = secretCode;
    }

    @Override
    public String toString(){
        return String.valueOf(this.secretCode);
    }
}