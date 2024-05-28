package com.javaproject.OnlineBanking.unit;

import java.util.Random;

public class AccountNumberGenerator {

    private static final int ACCOUNT_NUMBER_LENGTH = 12;

    public static String generateAccountNumber(){
        Random rand = new Random();
        StringBuilder accountNumber = new StringBuilder();

        // Generate a random 12-digit account number
        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            int digit = rand.nextInt(10); // generate a random digit (0-9)
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }

}
