package com.example.bank_service_graphql.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.bank_service_graphql.dtos.bankaccount.BankAccountDto;
import com.example.bank_service_graphql.dtos.user.UserDto;
import com.example.bank_service_graphql.enums.TransactionType;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TransactionDto {
    private String createdAt;
    private TransactionType transactionType;
    private Double amount;
    private BankAccountDto bankAccount;
    private UserDto user;
}
