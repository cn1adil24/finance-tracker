package com.vcoding.financetracker.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcoding.financetracker.transaction.entity.TransactionEntity;

public interface TransactionRepository
        extends JpaRepository<TransactionEntity, Long> {

}
