package com.javaproject.OnlineBanking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a bank account.
 * Annotated with @Entity to indicate that this is a JPA entity.
 * Annotated with @Table to specify the table details for this entity.
 */
@Getter
@Setter
@Table(name = "bank_entries")
@Entity
public class Account {

    /**
     * The unique ID of the account.
     * Annotated with @Id and @GeneratedValue to indicate that this field is the primary key and its value is automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The account number of the account.
     * Annotated with @Column to provide column details.
     */
    @Column(name = "account_number",unique = true,nullable = false)
    private String accountNumber;

    /**
     * The type of the account.
     */
    private String accountType;

    /**
     * The balance of the account.
     */
    private double balance;

    // Getter and Setter methods

    /**
     * Gets the id of the account.
     * @return the id of the account.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the account.
     * @param id the new id of the account.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the account number.
     * @return the account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     * @param accountNumber the new account number.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the account type.
     * @return the account type.
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets the account type.
     * @param accountType the new account type.
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * Gets the balance of the account.
     * @return the balance of the account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the account.
     * @param balance the new balance of the account.
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
     * Constructor with all parameters.
     * @param id the id of the account.
     * @param accountNumber the account number.
     * @param accountType the type of the account.
     * @param balance the balance of the account.
     */
    public Account(Long id, String accountNumber, String accountType, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    /**
     * Constructor without id parameter.
     * @param accountNumber the account number.
     * @param accountType the type of the account.
     * @param balance the balance of the account.
     */
    public Account(String accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }
}