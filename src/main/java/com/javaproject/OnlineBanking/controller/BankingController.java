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

@Controller
@RequestMapping("/account")
public class BankingController {

    @Autowired
    private BankingService bankService;

    @GetMapping("/new")
    public String showNewAccountForm() {
        return "new-account";
    }

    @PostMapping("/new")
    public String openAccount(@RequestParam String accountType, @RequestParam double initialDeposit, Model model) {
        Account account = bankService.openAccount(accountType, initialDeposit);
        model.addAttribute("account", account);
        return "account-success";
    }

    @GetMapping("/transactions/deposit")
    public String showDepositForm() {
        return "deposit";
    }

    @PostMapping("/transactions/deposit")
    public String deposit(@RequestParam String accountNumber, @RequestParam double amount, Model model) {
        bankService.deposit(accountNumber, amount);
        return "transaction-success";
    }

    @GetMapping("/transactions/withdraw")
    public String showWithdrawForm() {
        return "withdraw";
    }

    @PostMapping("/transactions/withdraw")
    public String withdraw(@RequestParam String accountNumber, @RequestParam double amount, Model model) {
        try {
            bankService.withdraw(accountNumber, amount);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "transaction-failure";
        }
        return "transaction-success";
    }

    @GetMapping("/transactions/transfer")
    public String showTransferForm() {
        return "transfer";
    }

    @PostMapping("/transactions/transfer")
    public String transfer(@RequestParam String fromAccount, @RequestParam String toAccount, @RequestParam double amount, Model model) {
        try {
            bankService.transfer(fromAccount, toAccount, amount);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "transaction-failure";
        }
        return "transaction-success";
    }
}