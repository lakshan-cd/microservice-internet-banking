package com.lakshancd.finance.core_banking_service.repository;

import com.lakshancd.finance.core_banking_service.model.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity , Long> {
}
