package com.javaproject.OnlineBanking.exception;

// This class is an exception class thrown when there are insufficient funds in an account

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(Long accountId) {
        super("Insufficient funds in account with ID: " + accountId);
    }
}
