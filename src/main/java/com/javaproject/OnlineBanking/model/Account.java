package com.javaproject.OnlineBanking.model;

import jakarta.persistence.*;

/**
 * Entity class for the Account.
 * Annotated with @Entity and @Table to indicate that it's a JPA entity and to specify the table name in the database.
 */
@Entity
@Table(name = "bank_entries")
public class Account {

    /**
     * The ID of the account.
     * Annotated with @Id and @GeneratedValue to indicate that it's the primary key and its value is automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * The account number of the account.
     * Annotated with @Column to specify attributes for the database column.
     */
    @Column(unique = true, nullable = false)
    private String accountNumber;

    /**
     * The type of the account.
     */
    private String accountType;

    /**
     * The balance of the account.
     */
    private double balance;

    /**
     * The user who owns the account.
     * Annotated with @ManyToOne and @JoinColumn to establish a many-to-one relationship with the User entity.
     */
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // Getters and setters...

    /**
     * Default constructor.
     */
    public Account() {
    }

    /**
     * Constructor with parameters.
     * @param accountNumber the account number.
     * @param accountType the account type.
     * @param balance the balance.
     * @param user the user.
     */
    public Account(String accountNumber, String accountType, double balance,
                   User user) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.user = user;
    }

    /**
     * Constructor with parameters including id.
     * @param id the id.
     * @param accountNumber the account number.
     * @param accountType the account type.
     * @param balance the balance.
     * @param user the user.
     */
    public Account(Long id, String accountNumber, String accountType, double balance,
                   User user) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.user = user;
    }
}