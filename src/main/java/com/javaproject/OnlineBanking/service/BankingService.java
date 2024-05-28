package com.javaproject.OnlineBanking.service;

import com.javaproject.OnlineBanking.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface BankingService {

    // Other methods and fields...

    @Transactional
    @Modifying
    void openNewAccount(String accountType, double initialDeposit);

    @Transactional
    @Modifying
    void depositMoney(String accountNumber, double amount);

    @Transactional
    @Modifying
    void withdrawMoney(String accountNumber, double amount);

    @Transactional
    @Modifying
    void transferMoney(String fromAccount, String toAccount, double amount);

    Account openAccount(String accountType, double initialDeposit);

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void transfer(String fromAccount, String toAccount, double amount);
}