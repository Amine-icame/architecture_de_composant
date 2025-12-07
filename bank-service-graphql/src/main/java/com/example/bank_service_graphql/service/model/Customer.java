package com.example.bank_service_graphql.service.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User {
    @Column(unique = true)
    private String identityRef;

    @OneToMany(mappedBy = "customer")
    private List<BankAccount> bankAccounts;
}
