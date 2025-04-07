package com.banking.bankingapi.model;

import java.math.BigDecimal;

public class Account {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal balance;

    public Account(Long id, String firstName, String lastName, BigDecimal balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
