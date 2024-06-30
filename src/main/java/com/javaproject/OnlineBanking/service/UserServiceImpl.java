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

@Service

public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    public void saveUser(String username, String password) {
        User user = new User(username, passwordEncoder.encode(password));
        userRepository.save(user);
    }



    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }



    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }


    // extra service to save user with accounts
    public void saveUserWithAccounts(String userName, String password, List<Account> accounts) {
        User user = new User(userName,passwordEncoder.encode(password));
        for (Account a: accounts) {
            a.setUser(user);
        }
        user.setAccounts(accounts);
        userRepository.save(user);
    }

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