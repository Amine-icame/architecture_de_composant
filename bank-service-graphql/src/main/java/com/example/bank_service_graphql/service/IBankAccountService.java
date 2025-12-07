package com.example.bank_service_graphql.service;

import com.example.bank_service_graphql.dtos.bankaccount.*;
import java.util.List;

public interface IBankAccountService {
    List<BankAccountDto> getAllBankAccounts();
    BankAccountDto getBankAccountByRib(String rib);
    AddBankAccountResponse saveBankAccount(AddBankAccountRequest dto);
}
