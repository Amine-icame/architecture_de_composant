package com.example.bank_service_graphql.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class GetTransactionListRequest {
    private String rib;
    private String dateFrom;
    private String dateTo;
}
