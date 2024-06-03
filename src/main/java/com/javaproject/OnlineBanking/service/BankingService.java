package com.javaproject.OnlineBanking.service;

import com.javaproject.OnlineBanking.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service interface for banking operations.
 * Annotated with @Service to indicate that it's a service component in the Spring context.
 */
@Service
public interface BankingService {

    // Other methods and fields...

    /**
     * Opens a new account with a specified account type and initial deposit.
     * Annotated with @Transactional and @Modifying to indicate that this method performs a transactional and modifying operation.
     * @param accountType the type of the account to be opened.
     * @param initialDeposit the initial deposit to be made into the account.
     */
    @Transactional
    @Modifying
    void openNewAccount(String accountType, double initialDeposit);

    /**
     * Deposits a specified amount of money into a specified account.
     * Annotated with @Transactional and @Modifying to indicate that this method performs a transactional and modifying operation.
     * @param accountNumber the number of the account to deposit money into.
     * @param amount the amount of money to deposit.
     */
    @Transactional
    @Modifying
    void depositMoney(String accountNumber, double amount);

    /**
     * Withdraws a specified amount of money from a specified account.
     * Annotated with @Transactional and @Modifying to indicate that this method performs a transactional and modifying operation.
     * @param accountNumber the number of the account to withdraw money from.
     * @param amount the amount of money to withdraw.
     */
    @Transactional
    @Modifying
    void withdrawMoney(String accountNumber, double amount);

    /**
     * Transfers a specified amount of money from one account to another.
     * Annotated with @Transactional and @Modifying to indicate that this method performs a transactional and modifying operation.
     * @param fromAccount the account to transfer money from.
     * @param toAccount the account to transfer money to.
     * @param amount the amount of money to transfer.
     */
    @Transactional
    @Modifying
    void transferMoney(String fromAccount, String toAccount, double amount);

    /**
     * Opens a new account with a specified account type and initial deposit.
     * @param accountType the type of the account to be opened.
     * @param initialDeposit the initial deposit to be made into the account.
     * @return the newly opened account.
     */
    Account openAccount(String accountType, double initialDeposit);

    /**
     * Deposits a specified amount of money into a specified account.
     * @param accountNumber the number of the account to deposit money into.
     * @param amount the amount of money to deposit.
     */
    void deposit(String accountNumber, double amount);

    /**
     * Withdraws a specified amount of money from a specified account.
     * @param accountNumber the number of the account to withdraw money from.
     * @param amount the amount of money to withdraw.
     */
    void withdraw(String accountNumber, double amount);

    /**
     * Transfers a specified amount of money from one account to another.
     * @param fromAccount the account to transfer money from.
     * @param toAccount the account to transfer money to.
     * @param amount the amount of money to transfer.
     */
    void transfer(String fromAccount, String toAccount, double amount);
}