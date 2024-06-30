package com.javaproject.OnlineBanking.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entity class for the User.
 * Annotated with @Entity and @Table to indicate that it's a JPA entity and to specify the table name in the database.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * The ID of the user.
     * Annotated with @Id and @GeneratedValue to indicate that it's the primary key and its value is automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * The username of the user.
     * Annotated with @Column to specify attributes for the database column.
     */
    @Column(unique = true, nullable = false)
    private String username;

    /**
     * The password of the user.
     * Annotated with @Column to specify attributes for the database column.
     */
    @Column(nullable = false)
    private String password;

    /**
     * The accounts of the user.
     * Annotated with @OneToMany to establish a one-to-many relationship with the Account entity.
     */
    @OneToMany(mappedBy = "user", cascade= CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    // Getters and setters...

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Constructor with parameters.
     * @param username the username.
     * @param password the password.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Constructor with parameters including id.
     * @param id the id.
     * @param username the username.
     * @param password the password.
     */
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /**
     * Constructor with parameters including accounts.
     * @param username the username.
     * @param password the password.
     * @param accounts the accounts.
     */
    public User(String username, String password,
                List<Account> accounts) {
        this.username = username;
        this.password = password;
        this.accounts = accounts;
    }
}