package com.example.bank_service_graphql.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CustomerDto {
    private String username;
    private String identityRef;
    private String firstname;
    private String lastname;
}