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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "user", cascade= CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password,
                List<Account> accounts) {
        this.username = username;
        this.password = password;
        this.accounts = accounts;
    }
}