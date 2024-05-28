package com.javaproject.OnlineBanking.service;

import com.javaproject.OnlineBanking.model.BankEntry;
import com.javaproject.OnlineBanking.repository.BankRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;
     @Override
     @Modifying
    @Transactional
    public BankEntry openAccount(String accountType, double initialBalance) {
        BankEntry bankEntry = new BankEntry();
        bankEntry.setAccountType(accountType);
        bankEntry.setBalance(initialBalance);
        return bankRepository.save(bankEntry);
    }
     Override
    @Transactional
    @Modifying
    public void deposit(String accountNumber, double amount) {
        BankEntry bankEntry = bankRepository.findByAccountNumber(accountNumber);
        bankEntry.setBalance(bankEntry.getBalance() + amount);
        bankRepository.save(bankEntry);
    }
     @Override
    @Transactional
    @Modifying
    public void withdraw(String accountNumber, double amount) throws Exception{
        BankEntry bankEntry = bankRepository.findByAccountNumber(accountNumber);
        if(bankEntry.getBalance() < amount) {
            throw new Exception("Insufficient balance");
        }
        bankEntry.setBalance(bankEntry.getBalance() - amount);
        bankRepository.save(bankEntry);
    }
    @Override
    @Transactional
    @Modifying
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws Exception {
        withdraw(fromAccountNumber, amount);
        deposit(toAccountNumber, amount);
    }

    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis();
    }

}