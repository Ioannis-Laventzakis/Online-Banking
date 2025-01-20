package com.javaproject.OnlineBanking.dto;


public class TransferForm {

    /**
     * The account number from which the amount will be transferred.
     */
    private Long fromAccountNumber;

    /**
     * The account number to which the amount will be transferred.
     */
    private Long toAccountNumber;

    /**
     * The amount to be transferred.
     */
    private Double amount;

    /**
     * Gets the account number from which the amount will be transferred.
     *
     * @return the from account number
     */
    public Long getFromAccountNumber() {
        return fromAccountNumber;
    }

    /**
     * Sets the account number from which the amount will be transferred.
     *
     * @param fromAccountNumber the from account number to set
     */
    public void setFromAccountNumber(Long fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    /**
     * Gets the account number to which the amount will be transferred.
     *
     * @return the to account number
     */
    public Long getToAccountNumber() {
        return toAccountNumber;
    }

    /**
     * Sets the account number to which the amount will be transferred.
     *
     * @param toAccountNumber the to account number to set
     */
    public void setToAccountNumber(Long toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    /**
     * Gets the amount to be transferred.
     *
     * @return the amount to be transferred
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the amount to be transferred.
     *
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}