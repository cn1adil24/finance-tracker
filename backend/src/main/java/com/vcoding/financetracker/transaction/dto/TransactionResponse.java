package com.vcoding.financetracker.transaction.dto;

import com.vcoding.financetracker.transaction.TransactionType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(
    Long id,
    BigDecimal amount,
    String description,
    LocalDateTime timestamp,
    TransactionType type) {}
