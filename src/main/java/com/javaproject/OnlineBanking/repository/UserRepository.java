package com.javaproject.OnlineBanking.repository;

import com.javaproject.OnlineBanking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the User entity.
 * Annotated with @Repository to indicate that it's a Spring Data JPA repository.
 * Extends JpaRepository to inherit several methods for working with User persistence, including save(), delete(), and findOne().
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    /**
     * Method to find a user by its username.
     * @param username the username to search for.
     * @return the user with the given username.
     */
    User findByUsername(String username);
}