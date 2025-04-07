package com.banking.bankingapi.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AccountListResponse {
    private Long accountId;
    private String firstName;
    private String lastName;
    private BigDecimal accountBalance;

    public AccountListResponse(Long accountId, String firstName, String lastName, BigDecimal accountBalance) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountBalance = accountBalance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
}
