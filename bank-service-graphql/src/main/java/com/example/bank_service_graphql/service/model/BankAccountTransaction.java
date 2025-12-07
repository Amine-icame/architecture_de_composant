package com.example.bank_service_graphql.service.model;

import jakarta.persistence.*;
import lombok.*;
import com.example.bank_service_graphql.enums.TransactionType;
import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class BankAccountTransaction {
    @Id @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private Double amount;

    @ManyToOne
    private BankAccount bankAccount;

    @ManyToOne
    private User user; // Qui a effectué la transaction
}
