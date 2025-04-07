package com.banking.bankingapi.repository;

import com.banking.bankingapi.model.Account;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AccountRepository {

    private final Map<Long, Account> accounts = new HashMap<>();
    private Long nextId = 1L;

    public Account save(Account account) {
        account.setId(nextId++);
        accounts.put(account.getId(), account);
        return account;
    }

    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public List<Account> findAll() {
        return new ArrayList<>(accounts.values());
    }

    public void deleteById(Long id) {
        accounts.remove(id);
    }

    public boolean existsById(Long id) {
        return accounts.containsKey(id);
    }
}