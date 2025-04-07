package com.banking.bankingapi.dto;

import java.math.BigDecimal;

public class TransactionRequest {
    private Long senderId;
    private Long receiverId;
    private BigDecimal transferAmount;

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

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }
}
