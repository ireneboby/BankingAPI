package com.banking.bankingapi.controller;

import com.banking.bankingapi.dto.CreateAccountRequest;
import com.banking.bankingapi.dto.AccountListResponse;
import com.banking.bankingapi.model.Account;
import com.banking.bankingapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest request) {
        try {
            Account createdAccount = accountService.createAccount(request);
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<AccountListResponse>> getAllAccounts() {
        try {
            List<AccountListResponse> accounts = accountService.listAccounts();
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
