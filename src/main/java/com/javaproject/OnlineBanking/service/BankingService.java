package com.javaproject.OnlineBanking.service;

import com.javaproject.OnlineBanking.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

    public interface BankingService {
        void openNewAccount(String accountType, double initialDeposit, Long userId);
        void depositMoney(String accountNumber, double amount);
        void withdrawMoney(String accountNumber, double amount);
        void transferMoney(String fromAccount, String toAccount, double amount);
    }