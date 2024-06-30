package com.javaproject.OnlineBanking.service;

import com.javaproject.OnlineBanking.model.Account;
import com.javaproject.OnlineBanking.repository.AccountRepository;
import com.javaproject.OnlineBanking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling user operations.
 * Annotated with @Service to indicate that it's a Spring service component.
 * Implements UserDetailsService for loading user-specific data.
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    /**
     * The UserRepository instance.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * The AccountRepository instance.
     */
    @Autowired
    private AccountRepository accountRepository;

    /**
     * The BCryptPasswordEncoder instance for encoding passwords.
     */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Saves a new user with the given username and password.
     * @param username the username of the user.
     * @param password the password of the user.
     */
    public void saveUser(String username, String password) {
        User user = new User(username, passwordEncoder.encode(password));
        userRepository.save(user);
    }

    /**
     * Finds a user by its username.
     * @param username the username to search for.
     * @return the user with the given username.
     */
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    /**
     * Checks if the raw password matches the encoded password.
     * @param rawPassword the raw password.
     * @param encodedPassword the encoded password.
     * @return true if the passwords match, false otherwise.
     */
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * Saves a new user with the given username, password, and accounts.
     * @param userName the username of the user.
     * @param password the password of the user.
     * @param accounts the accounts of the user.
     */
    public void saveUserWithAccounts(String userName, String password, List<Account> accounts) {
        User user = new User(userName,passwordEncoder.encode(password));
        for (Account a: accounts) {
            a.setUser(user);
        }
        user.setAccounts(accounts);
        userRepository.save(user);
    }

    /**
     * Loads the user by its username.
     * @param username the username to search for.
     * @return the UserDetails instance of the user.
     * @throws UsernameNotFoundException if the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("USER") // You can set roles/authorities here
                .build();
    }
}