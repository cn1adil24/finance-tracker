package com.vcoding.financetracker.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.vcoding.financetracker.transaction.TransactionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateTransactionRequest(
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    BigDecimal amount,

    @NotBlank(message = "Description is required")
    String description,

    @NotNull(message = "Timestamp is required")
    LocalDateTime timestamp,

    @NotNull(message = "Transaction type is required")
    TransactionType type
) {}
