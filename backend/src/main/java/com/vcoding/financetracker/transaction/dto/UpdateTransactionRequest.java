package com.vcoding.financetracker.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.vcoding.financetracker.transaction.TransactionType;

public record UpdateTransactionRequest(
    BigDecimal amount,
    String description,
    LocalDateTime timestamp,
    TransactionType type
) {}
