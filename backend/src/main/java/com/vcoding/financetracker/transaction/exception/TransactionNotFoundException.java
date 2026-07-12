package com.vcoding.financetracker.transaction.exception;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(Long transactionId) {
        super("Transaction with id " + transactionId + " was not found.");
    }
}
