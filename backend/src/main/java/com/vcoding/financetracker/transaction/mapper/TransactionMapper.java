package com.vcoding.financetracker.transaction.mapper;

import org.springframework.stereotype.Component;

import com.vcoding.financetracker.transaction.dto.CreateTransactionRequest;
import com.vcoding.financetracker.transaction.dto.TransactionResponse;
import com.vcoding.financetracker.transaction.dto.UpdateTransactionRequest;
import com.vcoding.financetracker.transaction.entity.TransactionEntity;

@Component
public class TransactionMapper {

    public TransactionEntity toEntity(
        CreateTransactionRequest request
    ) {
        TransactionEntity entity = new TransactionEntity();
        entity.setAmount(request.amount());
        entity.setDescription(request.description());
        entity.setTimestamp(request.timestamp());
        entity.setType(request.type());

        return entity;
    }

    public TransactionResponse toResponse(
        TransactionEntity entity
    ) {
        return new TransactionResponse(
            entity.getId(),
            entity.getAmount(),
            entity.getDescription(),
            entity.getTimestamp(),
            entity.getType()
        );
    }

    public void updateEntity(
        TransactionEntity entity,
        UpdateTransactionRequest request
    ) {
        entity.setAmount(request.amount());
        entity.setDescription(request.description());
        entity.setTimestamp(request.timestamp());
        entity.setType(request.type());
    }
}
