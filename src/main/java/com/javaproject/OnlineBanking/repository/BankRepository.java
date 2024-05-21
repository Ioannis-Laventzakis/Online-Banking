package com.javaproject.OnlineBanking.repository;

import com.javaproject.OnlineBanking.model.BankEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<BankEntry, Long>
{
    BankEntry findByAccountNumber(String accountNumber);
}
