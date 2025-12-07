package com.example.bank_service_graphql.dao;

import com.example.bank_service_graphql.service.model.BankAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface BankAccountTransactionRepository extends JpaRepository<BankAccountTransaction, Long> {
    // Méthode pour trouver les transactions d'un RIB entre deux dates
    List<BankAccountTransaction> findByBankAccount_RibAndCreatedAtBetween(String rib, Date from, Date to);
}
