package com.vcoding.financetracker.transaction.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.vcoding.financetracker.transaction.TransactionType;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(
        nullable = false,
        precision = 10,
        scale = 2
    )
    private BigDecimal amount;


    private String description;


    @Column(nullable = false)
    private LocalDateTime timestamp;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;


    public TransactionEntity() {}


    public Long getId() {
        return id;
    }


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }


    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


    public TransactionType getType() {
        return type;
    }


    public void setType(TransactionType type) {
        this.type = type;
    }
}
