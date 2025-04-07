package com.banking.bankingapi.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private Long transactionId;
    private Date dateTime;
    private Long senderId;
    private Long receiverId;
    private BigDecimal transferAmount;

    public Transaction(Long transactionId, Long senderId, Long receiverId, BigDecimal transferAmount) {
        this.transactionId = transactionId;
        this.dateTime = new Date(); // sets the current time
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.transferAmount = transferAmount;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }
}