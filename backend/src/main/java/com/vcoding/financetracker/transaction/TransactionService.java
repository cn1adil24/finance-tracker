package com.vcoding.financetracker.transaction;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vcoding.financetracker.transaction.dto.CreateTransactionRequest;
import com.vcoding.financetracker.transaction.dto.TransactionResponse;
import com.vcoding.financetracker.transaction.entity.TransactionEntity;
import com.vcoding.financetracker.transaction.exception.TransactionNotFoundException;
import com.vcoding.financetracker.transaction.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionResponse create(CreateTransactionRequest request) {
        TransactionEntity entity = new TransactionEntity();
        entity.setAmount(request.amount());
        entity.setDescription(request.description());
        entity.setTimestamp(request.timestamp());
        entity.setType(request.type());

        TransactionEntity savedEntity = transactionRepository.save(entity);

        return toResponse(savedEntity);
    }

    public List<TransactionResponse> getAll() {
        return transactionRepository.findAll()
                                    .stream()
                                    .map(this::toResponse)
                                    .collect(Collectors.toList());
    }

    public TransactionResponse getById(Long id) {
        TransactionEntity txn = 
            transactionRepository
                .findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));

        return toResponse(txn);
    }

    public void delete(Long id) {
        TransactionEntity entity = transactionRepository
            .findById(id)
            .orElseThrow(() -> new TransactionNotFoundException(id));

        transactionRepository.delete(entity);
    }

    private TransactionResponse toResponse(TransactionEntity entity) {
        return new TransactionResponse(
            entity.getId(),
            entity.getAmount(),
            entity.getDescription(),
            entity.getTimestamp(),
            entity.getType()
        );
    }
}
