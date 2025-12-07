package com.example.bank_service_graphql.dtos.bankaccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.bank_service_graphql.dtos.customer.CustomerDto;
import com.example.bank_service_graphql.enums.AccountStatus;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AddBankAccountResponse {
    private String message;
    private String rib;
    private Double amount;
    private String createdAt;
    private AccountStatus accountStatus;
    private CustomerDto customer;
}