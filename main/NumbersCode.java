package main;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumbersCode extends SecretCode{


    private int secretCode;

    NumbersCode() {
    }

    public void getCode() {
        Random random = new Random();
        int secretNumberCode = 0;

        do{
            Set<Integer> used_digits = new HashSet<>();
            int[] code_array = new int[4];
            int insertion_index = 0;

            do {
                int nextDigit = random.nextInt(10);

                if (used_digits.contains(nextDigit))
                    continue;

                used_digits.add(nextDigit);
                code_array[insertion_index] = nextDigit;
                ++insertion_index;

            } while (insertion_index < 3);

            secretNumberCode += code_array[0] * 1000;
            secretNumberCode += code_array[1] * 100;
            secretNumberCode += code_array[2] * 10;
            secretNumberCode += code_array[3];
            this.secretCode = secretNumberCode;

        }while (secretNumberCode < 1000);
    }

    @Override
    public String toString(){
        return String.valueOf(this.secretCode);
    }
}