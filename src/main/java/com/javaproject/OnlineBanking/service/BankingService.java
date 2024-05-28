package com.javaproject.OnlineBanking.service;

public interface BankingService {
    void openNewAccount(String accountType, double initialDeposit);
    void depositMoney(String accountNumber, double amount);
    void withdrawMoney(String accountNumber, double amount);
    void transferMoney(String fromAccount, String toAccount, double amount);
}
