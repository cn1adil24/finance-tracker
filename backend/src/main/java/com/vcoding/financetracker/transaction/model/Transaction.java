package com.vcoding.financetracker.transaction.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.vcoding.financetracker.transaction.TransactionType;

public class Transaction {

    private Long id;
    private BigDecimal amount;
    private String description;
    private LocalDateTime timestamp;
    private TransactionType type;

    public Transaction() {}

    public Transaction(Long id, BigDecimal amount, String description,
                        LocalDateTime timestamp, TransactionType type) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
        this.type = type;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }
}