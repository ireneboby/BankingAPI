package com.banking.bankingapi.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionHistoryResponse {
    private Date dateTime;
    private BigDecimal amount;
    private String direction; // SENT or RECEIVED
    private Long counterpartyId;

    public TransactionHistoryResponse(Date dateTime, BigDecimal amount, String direction, Long counterpartyId) {
        this.dateTime = dateTime;
        this.amount = amount;
        this.direction = direction;
        this.counterpartyId = counterpartyId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDirection() {
        return direction;
    }

    public Long getCounterpartyId() {
        return counterpartyId;
    }
}
