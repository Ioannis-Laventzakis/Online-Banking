package com.javaproject.OnlineBanking.model;

import jakarta.persistence.*;


@Entity
@Table(name = "accounts")
public class Account {

    /**
     * The unique identifier for the account.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * The unique account number provided by the bank system.
     * This field is unique and cannot be null.
     */
    @Column(unique = true, nullable = false)
    private String accountNumber;

    /**
     * The type of the account (e.g., savings, checking).
     */
    private String accountType;

    /**
     * The current balance of the account.
     */
    private double balance;

    /**
     * The user who owns the account.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Gets the user who owns the account.
     *
     * @return the user who owns the account
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who owns the account.
     *
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the unique identifier for the account.
     *
     * @return the unique identifier for the account
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the unique account number.
     *
     * @return the unique account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the type of the account.
     *
     * @return the type of the account
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Gets the current balance of the account.
     *
     * @return the current balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the unique identifier for the account.
     *
     * @param id the unique identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Sets the unique account number.
     *
     * @param accountNumber the unique account number to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Sets the type of the account.
     *
     * @param accountType the type of the account to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * Sets the current balance of the account.
     *
     * @param balance the current balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Default constructor.
     */
    public Account() {
    }

    /**
     * Constructs a new Account with the specified details.
     *
     * @param accountNumber the unique account number
     * @param accountType the type of the account
     * @param balance the current balance of the account
     * @param user the user who owns the account
     */
    public Account(String accountNumber, String accountType, double balance, User user) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.user = user;
    }

    /**
     * Constructs a new Account with the specified details including the unique identifier.
     *
     * @param id the unique identifier for the account
     * @param accountNumber the unique account number
     * @param accountType the type of the account
     * @param balance the current balance of the account
     * @param user the user who owns the account
     */
    public Account(Long id, String accountNumber, String accountType, double balance, User user) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.user = user;
    }
}