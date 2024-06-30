package com.javaproject.OnlineBanking.service;

import com.javaproject.OnlineBanking.model.Account;
import com.javaproject.OnlineBanking.model.User;
import com.javaproject.OnlineBanking.repository.AccountRepository;
import com.javaproject.OnlineBanking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for handling banking operations.
 * Annotated with @Service to indicate that it's a Spring service component.
 */
@Service
public class BankingServiceImpl implements BankingService {

    /**
     * The AccountRepository instance.
     */
    @Autowired
    private AccountRepository accountRepository;

    /**
     * The UserRepository instance.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Opens a new account for a user.
     * @param accountType the type of the account.
     * @param initialDeposit the initial deposit for the account.
     * @param userId the id of the user.
     */
    @Override
    @Transactional
    @Modifying
    public void openNewAccount(String accountType, double initialDeposit, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Account account = new Account();
        account.setAccountNumber(AccountNumberGenerator.generateAccountNumber());
        account.setAccountType(accountType);
        account.setBalance(initialDeposit);
        account.setUser(user);
        accountRepository.save(account);
    }

    /**
     * Deposits money into an account.
     * @param accountNumber the account number.
     * @param amount the amount to deposit.
     */
    @Override
    @Transactional
    @Modifying
    public void depositMoney(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        } else {
            throw new RuntimeException("Account not exist");
        }
    }

    /**
     * Withdraws money from an account.
     * @param accountNumber the account number.
     * @param amount the amount to withdraw.
     */
    @Override
    @Transactional
    @Modifying
    public void withdrawMoney(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);
        } else {
            throw new RuntimeException("Account not exist or insufficient funds for withdrawal");
        }
    }

    /**
     * Transfers money from one account to another.
     * @param fromAccount the account to transfer from.
     * @param toAccount the account to transfer to.
     * @param amount the amount to transfer.
     */
    @Override
    @Transactional
    @Modifying
    public void transferMoney(String fromAccount, String toAccount, double amount) {
        withdrawMoney(fromAccount, amount);
        depositMoney(toAccount, amount);
    }
}