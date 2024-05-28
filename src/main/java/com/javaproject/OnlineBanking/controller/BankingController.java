package com.javaproject.OnlineBanking.controller;

import com.javaproject.OnlineBanking.model.Account;
import com.javaproject.OnlineBanking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for handling banking operations.
 */
@Controller
@RequestMapping("/account")
public class BankingController {

    @Autowired
    private BankingService bankingService;

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    /**
     * Displays the form for creating a new account.
     * @return the name of the view to be rendered
     */
    @GetMapping("/new")
    public String showNewAccountForm() {
        return "new-account";
    }

    /**
     * Handles the creation of a new account.
     * @param accountType the type of the account to be created
     * @param initialDeposit the initial deposit for the account
     * @param model the model to add attributes to for the view
     * @return the name of the view to be rendered
     */
    @PostMapping("/new")
    public String openAccount(@RequestParam String accountType, @RequestParam double initialDeposit, Model model) {
        Account account = bankingService.openAccount(accountType, initialDeposit);
        model.addAttribute("account", account);
        return "account-success";
    }

    /**
     * Displays the form for making a deposit.
     * @return the name of the view to be rendered
     */
    @GetMapping("/transactions/deposit")
    public String showDepositForm() {
        return "deposit";
    }

    /**
     * Handles a deposit transaction.
     * @param accountNumber the account number to deposit to
     * @param amount the amount to deposit
     * @param model the model to add attributes to for the view
     * @return the name of the view to be rendered
     */
    @PostMapping("/transactions/deposit")
    public String deposit(@RequestParam String accountNumber, @RequestParam double amount, Model model) {
        bankingService.deposit(accountNumber, amount);
        return "transaction-success";
    }

    /**
     * Displays the form for making a withdrawal.
     * @return the name of the view to be rendered
     */
    @GetMapping("/transactions/withdraw")
    public String showWithdrawForm() {
        return "withdraw";
    }

    /**
     * Handles a withdrawal transaction.
     * @param accountNumber the account number to withdraw from
     * @param amount the amount to withdraw
     * @param model the model to add attributes to for the view
     * @return the name of the view to be rendered
     */
    @PostMapping("/transactions/withdraw")
    public String withdraw(@RequestParam String accountNumber, @RequestParam double amount, Model model) {
        try {
            bankingService.withdraw(accountNumber, amount);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "transaction-failure";
        }
        return "transaction-success";
    }

    /**
     * Displays the form for making a transfer.
     * @return the name of the view to be rendered
     */
    @GetMapping("/transactions/transfer")
    public String showTransferForm() {
        return "transfer";
    }

    /**
     * Handles a transfer transaction.
     * @param fromAccount the account number to transfer from
     * @param toAccount the account number to transfer to
     * @param amount the amount to transfer
     * @param model the model to add attributes to for the view
     * @return the name of the view to be rendered
     */
    @PostMapping("/transactions/transfer")
    public String transfer(@RequestParam String fromAccount, @RequestParam String toAccount, @RequestParam double amount, Model model) {
        try {
            bankingService.transfer(fromAccount, toAccount, amount);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "transaction-failure";
        }
        return "transaction-success";
    }
}