package com.javaproject.OnlineBanking.service;

import com.javaproject.OnlineBanking.model.Account;
import com.javaproject.OnlineBanking.repository.AccountRepository;
import com.javaproject.OnlineBanking.unit.AccountNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the service class for the banking system.
 * It implements the BankingService interface and provides the actual implementation of the methods.
 * It uses the AccountRepository to interact with the database.
 */
@Service
public class BankingServiceImpl implements BankingService {

    // The repository to interact with the database
    @Autowired
    private AccountRepository repository;

    /**
     * This method is used to open a new account.
     * It creates a new Account object, sets the account number, account type, and initial balance, and saves it to the database.
     * @param accountType the type of the account
     * @param initialDeposit the initial deposit to the account
     */
    @Override
    @org.springframework.transaction.annotation.Transactional
    @Modifying
    public void openNewAccount(String accountType, double initialDeposit) {

        Account account = new Account();
        account.setAccountNumber(AccountNumberGenerator.generateAccountNumber());
        account.setAccountType(accountType);
        account.setBalance(initialDeposit);
        repository.save(account);
    }

    /**
     * This method is used to deposit money into an account.
     * It finds the account by its account number, adds the deposit amount to the balance, and saves the updated account to the database.
     * If the account does not exist, it throws a RuntimeException.
     * @param accountNumber the account number
     * @param amount the amount to deposit
     */
    @Override
    @org.springframework.transaction.annotation.Transactional
    @Modifying
    public void depositMoney(String accountNumber, double amount) {
        Account account = repository.findByAccountNumber(accountNumber);
        if(account != null){
            account.setBalance(account.getBalance() + amount);
            repository.save(account);
        }else{
            throw new RuntimeException("Account not exist");
        }
    }

    /**
     * This method is used to withdraw money from an account.
     * It finds the account by its account number, subtracts the withdrawal amount from the balance, and saves the updated account to the database.
     * If the account does not exist or the balance is insufficient, it throws a RuntimeException.
     * @param accountNumber the account number
     * @param amount the amount to withdraw
     */
    @Override
    @org.springframework.transaction.annotation.Transactional
    @Modifying
    public void withdrawMoney(String accountNumber, double amount) {

        Account account = repository.findByAccountNumber(accountNumber);
        if(account != null && account.getBalance() >= amount){
            account.setBalance(account.getBalance() - amount);
            repository.save(account);
        }else{
            throw new RuntimeException("Account not exist or insufficient funds for withdrawal");
        }

    }

    /**
     * This method is used to transfer money from one account to another.
     * It calls the withdrawMoney method to withdraw money from the fromAccount, and the depositMoney method to deposit money into the toAccount.
     * @param fromAccount the account to withdraw money from
     * @param toAccount the account to deposit money into
     * @param amount the amount to transfer
     */
    @Override
    @Transactional
    @Modifying
    public void transferMoney(String fromAccount, String toAccount, double amount) {
        withdrawMoney(fromAccount, amount);
        depositMoney(toAccount, amount);
    }

    @Override
    public Account openAccount(String accountType, double initialDeposit) {
        return null;
    }

    @Override
    public void deposit(String accountNumber, double amount) {

    }

    @Override
    public void withdraw(String accountNumber, double amount) {

    }

    @Override
    public void transfer(String fromAccount, String toAccount, double amount) {

    }
}