package com.banking.bankingapi.controller;

import com.banking.bankingapi.dto.TransactionRequest;
import com.banking.bankingapi.dto.TransactionHistoryResponse;
import com.banking.bankingapi.model.Transaction;
import com.banking.bankingapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionRequest request) {
        try {
            Transaction newTransaction = transactionService.transferFunds(request);
            return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<TransactionHistoryResponse>> getTransactionHistory(@RequestParam Long accountId) {
        try {
           List<TransactionHistoryResponse> history = transactionService.getHistory(accountId);
            return new ResponseEntity<>(history, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
