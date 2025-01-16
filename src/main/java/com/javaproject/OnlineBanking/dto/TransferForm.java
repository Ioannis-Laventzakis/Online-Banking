package com.javaproject.OnlineBanking.dto;

public class TransferForm {
    // The Transfer form class is a DTO (Data transfer Object). It is a design pattern used to transfer data between

    private Long fromAccountNumber;
    private Long toAccountNumber;
    private Double amount;

    // Getters and Setters
    public Long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(Long fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public Long getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(Long toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
