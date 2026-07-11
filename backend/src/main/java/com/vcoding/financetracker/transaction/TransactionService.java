package com.vcoding.financetracker.transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vcoding.financetracker.transaction.dto.CreateTransactionRequest;
import com.vcoding.financetracker.transaction.dto.TransactionResponse;
import com.vcoding.financetracker.transaction.model.Transaction;

@Service
public class TransactionService {

    private final Map<Long, Transaction> store = new HashMap<>();
    private long idCounter = 1;

    public TransactionResponse create(CreateTransactionRequest request) {
        Long id = idCounter++;

        Transaction txn = new Transaction(
            id,
            request.amount(),
            request.description(),
            request.timestamp(),
            request.type()
        );

        store.put(id, txn);

        return toResponse(txn);
    }

    public List<TransactionResponse> getAll() {
        return store.values()
                    .stream()
                    .map(this::toResponse)
                    .collect(Collectors.toList());
    }

    public TransactionResponse getById(Long id) {
        Transaction txn = store.get(id);
        if (txn == null) {
            throw new RuntimeException("Transaction not found: " + id);
        }

        return toResponse(txn);
    }

    private TransactionResponse toResponse(Transaction txn) {
        return new TransactionResponse(
            txn.getId(),
            txn.getAmount(),
            txn.getDescription(),
            txn.getTimestamp(),
            txn.getType()
        );
    }
}
