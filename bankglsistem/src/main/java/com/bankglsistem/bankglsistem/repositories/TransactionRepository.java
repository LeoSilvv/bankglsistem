package com.bankglsistem.bankglsistem.repositories;

import com.bankglsistem.bankglsistem.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
