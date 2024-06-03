package com.javaproject.OnlineBanking.controller;

import com.javaproject.OnlineBanking.model.Account;
import com.javaproject.OnlineBanking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Min;

/**
 * Controller for handling banking operations.
 */
@Controller
@RequestMapping("/account")
@Validated
public class BankingController {

    private static final Logger logger = LoggerFactory.getLogger(BankingController.class);

    @Autowired
    private BankingService bankingService;

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/new")
    public String showNewAccountForm() {
        return "new-account";
    }

    @PostMapping("/new")
    public String openAccount(@RequestParam String accountType,
                              @RequestParam @Min(0) double initialDeposit,
                              Model model) {
        logger.info("Opening new account of type: {}", accountType);
        try {
            Account account = bankingService.openAccount(accountType, initialDeposit);
            model.addAttribute("account", account);
            logger.info("Account created successfully: {}", account);
            return "account-success";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            logger.error("Error creating account: {}", e.getMessage());
            return "account-failure";
        }
    }

    @GetMapping("/transactions/deposit")
    public String showDepositForm() {
        return "deposit";
    }

    @PostMapping("/transactions/deposit")
    public String deposit(@RequestParam String accountNumber,
                          @RequestParam @Min(0) double amount,
                          Model model) {
        logger.info("Depositing {} to account {}", amount, accountNumber);
        try {
            bankingService.deposit(accountNumber, amount);
            logger.info("Deposit successful");
            return "transaction-success";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            logger.error("Error during deposit: {}", e.getMessage());
            return "transaction-failure";
        }
    }

    @GetMapping("/transactions/withdraw")
    public String showWithdrawForm() {
        return "withdraw";
    }

    @PostMapping("/transactions/withdraw")
    public String withdraw(@RequestParam String accountNumber,
                           @RequestParam @Min(0) double amount,
                           Model model) {
        logger.info("Withdrawing {} from account {}", amount, accountNumber);
        try {
            bankingService.withdraw(accountNumber, amount);
            logger.info("Withdrawal successful");
            return "transaction-success";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            logger.error("Error during withdrawal: {}", e.getMessage());
            return "transaction-failure";
        }
    }

    @GetMapping("/transactions/transfer")
    public String showTransferForm() {
        return "transfer";
    }

    @PostMapping("/transactions/transfer")
    public String transfer(@RequestParam String fromAccount,
                           @RequestParam String toAccount,
                           @RequestParam @Min(0) double amount,
                           Model model) {
        logger.info("Transferring {} from account {} to account {}", amount, fromAccount, toAccount);
        try {
            bankingService.transfer(fromAccount, toAccount, amount);
            logger.info("Transfer successful");
            return "transaction-success";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            logger.error("Error during transfer: {}", e.getMessage());
            return "transaction-failure";
        }
    }
}