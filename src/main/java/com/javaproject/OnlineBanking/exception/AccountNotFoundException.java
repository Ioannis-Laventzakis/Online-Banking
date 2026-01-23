package com.javaproject.OnlineBanking.exception;

// This class is an exception class thrown when an account is not found

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Long accountId ) {super("Account not found with ID: " + accountId);
    }
}
