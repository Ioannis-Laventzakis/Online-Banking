package com.javaproject.OnlineBanking.controller;

import com.javaproject.OnlineBanking.service.BankingService;
import com.javaproject.OnlineBanking.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for handling account related requests.
 */
@Controller
public class AccountController {
    @Autowired
    private BankingService bankingService;

    @Autowired
    private UserServiceImpl userService;

    /**
     * Handles GET requests to the home page.
     * @return the name of the home page view.
     */
    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    /**
     * Handles GET requests to the account opening form.
     * @return the name of the account opening form view.
     */
    @GetMapping("/openAccount")
    public String showOpenAccountForm() {
        return "openAccount";
    }

    /**
     * Handles POST requests to open a new account.
     * @param accountType the type of the account to be opened.
     * @param initialDeposit the initial deposit for the account.
     * @param userDetails the details of the authenticated user.
     * @param model the model to add attributes to.
     * @return a redirect to the account success view.
     */
    @PostMapping("/openAccount")
    public String openNewAccount(
            @RequestParam String accountType,
            @RequestParam double initialDeposit,
            @AuthenticationPrincipal UserDetails userDetails,
            Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        bankingService.openNewAccount(accountType, initialDeposit, user.getId());
        model.addAttribute("message", "Account successfully created!");
        return "redirect:/accountSuccess";
    }

    /**
     * Handles GET requests to the account success page.
     * @return the name of the account success view.
     */
    @GetMapping("/accountSuccess")
    public String showAccountSuccess() {
        return "accountSuccess";
    }

    /**
     * Handles GET requests to the deposit form.
     * @return the name of the deposit form view.
     */
    @GetMapping("/transactions/deposit")
    public String showDepositForm() {
        return "deposit";
    }

    /**
     * Handles POST requests to deposit money into an account.
     * @param accountNumber the number of the account to deposit into.
     * @param amount the amount to deposit.
     * @return a redirect to the home page.
     */
    @PostMapping("/transactions/deposit")
    public String depositMoney(
            @RequestParam String accountNumber,
            @RequestParam double amount) {
        bankingService.depositMoney(accountNumber, amount);
        return "redirect:/";
    }

    /**
     * Handles GET requests to the withdraw form.
     * @return the name of the withdraw form view.
     */
    @GetMapping("/transactions/withdraw")
    public String showWithdrawForm() {
        return "withdraw";
    }

    /**
     * Handles POST requests to withdraw money from an account.
     * @param accountNumber the number of the account to withdraw from.
     * @param amount the amount to withdraw.
     * @return a redirect to the home page.
     */
    @PostMapping("/transactions/withdraw")
    public String withdrawMoney(@RequestParam String accountNumber, @RequestParam double amount) {
        bankingService.withdrawMoney(accountNumber, amount);
        return "redirect:/";
    }

    /**
     * Handles GET requests to the transfer form.
     * @return the name of the transfer form view.
     */
    @GetMapping("/transactions/transfer")
    public String showTransferForm() {
        return "transfer";
    }

    /**
     * Handles POST requests to transfer money between accounts.
     * @param fromAccount the number of the account to transfer from.
     * @param toAccount the number of the account to transfer to.
     * @param amount the amount to transfer.
     * @return a redirect to the home page.
     */
    @PostMapping("/transactions/transfer")
    public String transferMoney(@RequestParam String fromAccount, @RequestParam String toAccount, @RequestParam double amount) {
        bankingService.transferMoney(fromAccount, toAccount, amount);
        return "redirect:/";
    }
}