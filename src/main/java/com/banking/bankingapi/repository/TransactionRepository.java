package com.banking.bankingapi.repository;

import com.banking.bankingapi.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();
    private Long nextTransactionId = 1L;

    public Transaction save(Transaction transaction) {
        transaction.setTransactionId(nextTransactionId++);
        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> findAll() {
        return transactions;
    }

    public Optional<Transaction> findByTransactionId(Long transactionId) {
        for (Transaction t : transactions) {
            if (t.getTransactionId().equals(transactionId)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public List<Transaction> findByAccountId(Long accountId) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getSenderId().equals(accountId) || t.getReceiverId().equals(accountId)) {
                result.add(t);
            }
        }
        return result;
    }
}