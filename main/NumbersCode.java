package main;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumbersCode extends SecretCode{

    private int secretCode;

    public NumbersCode() {
    }

    public NumbersCode(String code) {
        int intCode = Integer.parseInt(code);
        setSecretCode(intCode);
    }

    @Override
    public void getCode() {
        Random random = new Random();

        do {
            Set<Integer> usedDigits = new HashSet<>();
            int[] codeArray = new int[10];

            for (int i = 0; i < codeArray.length; i++) {
                int nextDigit;
                do {
                    nextDigit = random.nextInt(10);
                } while (usedDigits.contains(nextDigit));
                usedDigits.add(nextDigit);
                codeArray[i] = nextDigit;
            }
            this.secretCode = codeArray[0] * 1000000000 + codeArray[1] * 100000000 + codeArray[2] * 10000000 + codeArray[3] * 1000000 + codeArray[4] * 100000 + codeArray[5] * 10000 + codeArray[6] * 1000 + codeArray[7] * 100 + codeArray[8] * 10 + codeArray[9];
        } while (this.secretCode < 1000000000);
    }

    public String getSecretCode() {
        if(this.secretCode == 0)
            this.getCode();
        return String.valueOf(this.secretCode);
    }

    public void setSecretCode(int secretCode) {
        this.secretCode = secretCode;
    }

    @Override
    public String toString(){
        return String.valueOf(this.secretCode);
    }
}