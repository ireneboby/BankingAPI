package com.banking.bankingapi.service;

import com.banking.bankingapi.dto.CreateAccountRequest;
import com.banking.bankingapi.dto.AccountListResponse;
import com.banking.bankingapi.model.Account;
import com.banking.bankingapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(CreateAccountRequest request) {
        if (request.getFirstName() == null || request.getFirstName().isBlank() ||
            request.getLastName() == null || request.getLastName().isBlank()) {
            throw new IllegalArgumentException("First and last name are required.");
        }

        if (request.getInitialBalance() == null || request.getInitialBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance must be non-negative.");
        }

        Account account = new Account(
                null,   // repository sets the id
                request.getFirstName(),
                request.getLastName(),
                request.getInitialBalance()
        );

        return accountRepository.save(account);
    }

    public List<AccountListResponse> listAccounts() {
        return accountRepository.findAll().stream().map(account -> new AccountListResponse
            (
                account.getId(),
                account.getFirstName(),
                account.getLastName(),
                account.getBalance()
            )).toList();
    }
}
