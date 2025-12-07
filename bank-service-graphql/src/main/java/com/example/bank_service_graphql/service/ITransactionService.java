package com.example.bank_service_graphql.service;

import com.example.bank_service_graphql.dtos.transaction.*;
import java.util.List;

public interface ITransactionService {
    AddWirerTransferResponse wiredTransfer(AddWirerTransferRequest dto);
    List<TransactionDto> getTransactions(GetTransactionListRequest dto);
}
