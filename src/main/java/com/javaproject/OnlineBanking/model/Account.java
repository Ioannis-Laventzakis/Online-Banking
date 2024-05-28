package com.javaproject.OnlineBanking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank_entries")
@Entity
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "account_number",unique = true,nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private double balance;

  @Column(name= "account_type", nullable = false)
private String accountType;

}