package com.javaproject.OnlineBanking.repository;

import com.javaproject.OnlineBanking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumber(String accountNumber);
}
