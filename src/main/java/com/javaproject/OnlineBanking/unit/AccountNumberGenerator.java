package com.javaproject.OnlineBanking.unit;

import java.util.Random;

/**
 * Utility class for generating account numbers.
 */
public class AccountNumberGenerator {

    /**
     * The length of the account number to be generated.
     */
    private static final int ACCOUNT_NUMBER_LENGTH = 12;

    /**
     * Generates a random 12-digit account number.
     * @return the generated account number as a string.
     */
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