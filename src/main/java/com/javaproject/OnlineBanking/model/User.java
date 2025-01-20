package com.javaproject.OnlineBanking.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    /**
     * The unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * The unique username of the user.
     * This field is unique and cannot be null.
     */
    @Column(unique = true, nullable = false)
    private String username;

    /**
     * The password of the user.
     * This field cannot be null.
     */
    @Column(nullable = false)
    private String password;

    /**
     * The list of accounts associated with the user.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    /**
     * Gets the list of accounts associated with the user.
     *
     * @return the list of accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Sets the list of accounts associated with the user.
     *
     * @param accounts the list of accounts to set
     */
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Gets the unique identifier for the user.
     *
     * @return the unique identifier for the user
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the unique username of the user.
     *
     * @return the unique username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the unique identifier for the user.
     *
     * @param id the unique identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Sets the unique username of the user.
     *
     * @param username the unique username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Constructs a new User with the specified details.
     *
     * @param username the unique username
     * @param password the password of the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Constructs a new User with the specified details including the unique identifier.
     *
     * @param id the unique identifier for the user
     * @param username the unique username
     * @param password the password of the user
     */
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /**
     * Constructs a new User with the specified details including the list of accounts.
     *
     * @param username the unique username
     * @param password the password of the user
     * @param accounts the list of accounts associated with the user
     */
    public User(String username, String password, List<Account> accounts) {
        this.username = username;
        this.password = password;
        this.accounts = accounts;
    }
}