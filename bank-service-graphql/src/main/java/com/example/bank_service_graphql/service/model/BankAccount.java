package com.example.bank_service_graphql.service.model;
import jakarta.persistence.*;
import lombok.*;
import com.example.bank_service_graphql.enums.AccountStatus;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class BankAccount {
    @Id @GeneratedValue
    private Long id;
    private String rib;
    private Double amount;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @ManyToOne
    private Customer customer;
}
