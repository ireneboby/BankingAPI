package com.banking.bankingapi.service;

import com.banking.bankingapi.dto.TransactionRequest;
import com.banking.bankingapi.dto.TransactionHistoryResponse;
import com.banking.bankingapi.model.Account;
import com.banking.bankingapi.model.Transaction;
import com.banking.bankingapi.repository.AccountRepository;
import com.banking.bankingapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Transaction transferFunds(TransactionRequest request) {
        Long senderId = request.getSenderId();
        Long receiverId = request.getReceiverId();
        BigDecimal transferAmount = request.getTransferAmount();

        if (senderId == null || receiverId == null) {
            throw new IllegalArgumentException("Both sender and receiver IDs are required");
        }

        if (transferAmount == null || transferAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than 0");
        }

        Account sender = accountRepository.findById(senderId).orElseThrow(() -> new IllegalArgumentException("Sender account not found"));
        Account receiver = accountRepository.findById(receiverId).orElseThrow(() -> new IllegalArgumentException("Receiver account not found"));

        if (sender.getBalance().compareTo(transferAmount) < 0) {
            throw new IllegalArgumentException("Not enough balance in sender account");
        }

        // Perform transfer
        sender.setBalance(sender.getBalance().subtract(transferAmount));
        receiver.setBalance(receiver.getBalance().add(transferAmount));

        // Save transaction
        Transaction transaction = new Transaction(
                null,
                senderId,
                receiverId,
                transferAmount
        );

        return transactionRepository.save(transaction);
    }

    public List<TransactionHistoryResponse> getHistory(Long accountId) {
        if (accountId == null) {
            throw new IllegalArgumentException("Account ID required.");
        }

        if (!accountRepository.existsById(accountId)) {
            throw new IllegalArgumentException("Account ID not associated with any account.");
        }

        List<Transaction> history = transactionRepository.findByAccountId(accountId);

        return history.stream()
            .map(t -> {
                String direction = t.getSenderId().equals(accountId) ? "SENT" : "RECEIVED";
                Long counterparty = t.getSenderId().equals(accountId) ? t.getReceiverId() : t.getSenderId();
                return new TransactionHistoryResponse(t.getDateTime(), t.getTransferAmount(), direction, counterparty);
            })
            .toList();
    }
}