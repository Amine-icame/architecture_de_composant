package com.example.bank_service_graphql.dtos.bankaccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AddBankAccountRequest {
    private String rib;
    private Double amount;
    private String customerIdentityRef;
}
