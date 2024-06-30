package com.javaproject.OnlineBanking.repository;

import com.javaproject.OnlineBanking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Account entity.
 * Annotated with @Repository to indicate that it's a Spring Data JPA repository.
 * Extends JpaRepository to inherit several methods for working with Account persistence, including save(), delete(), and findOne().
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>
{
    /**
     * Method to find an account by its account number.
     * @param accountNumber the account number to search for.
     * @return the account with the given account number.
     */
    Account findByAccountNumber(String accountNumber);
}