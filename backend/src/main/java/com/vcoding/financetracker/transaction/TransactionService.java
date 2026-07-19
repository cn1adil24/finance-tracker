package com.vcoding.financetracker.transaction;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vcoding.financetracker.transaction.dto.CreateTransactionRequest;
import com.vcoding.financetracker.transaction.dto.TransactionResponse;
import com.vcoding.financetracker.transaction.entity.TransactionEntity;
import com.vcoding.financetracker.transaction.exception.TransactionNotFoundException;
import com.vcoding.financetracker.transaction.mapper.TransactionMapper;
import com.vcoding.financetracker.transaction.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionMapper mapper) {
        this.transactionRepository = transactionRepository;
        this.mapper = mapper;
    }

    public TransactionResponse create(CreateTransactionRequest request) {
        TransactionEntity entity = mapper.toEntity(request);

        TransactionEntity savedEntity = transactionRepository.save(entity);

        return mapper.toResponse(savedEntity);
    }

    public List<TransactionResponse> getAll() {
        return transactionRepository.findAll()
                                    .stream()
                                    .map(mapper::toResponse)
                                    .collect(Collectors.toList());
    }

    public TransactionResponse getById(Long id) {
        TransactionEntity txn = 
            transactionRepository
                .findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));

        return mapper.toResponse(txn);
    }

    public void delete(Long id) {
        TransactionEntity entity = transactionRepository
            .findById(id)
            .orElseThrow(() -> new TransactionNotFoundException(id));

        transactionRepository.delete(entity);
    }
}
