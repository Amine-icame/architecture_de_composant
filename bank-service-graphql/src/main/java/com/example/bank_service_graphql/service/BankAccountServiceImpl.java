package com.example.bank_service_graphql.service;


import lombok.AllArgsConstructor;
import com.example.bank_service_graphql.dao.BankAccountRepository;
import com.example.bank_service_graphql.dao.CustomerRepository;
import com.example.bank_service_graphql.dtos.bankaccount.*;
import com.example.bank_service_graphql.enums.AccountStatus;
import com.example.bank_service_graphql.service.exception.BusinessException;
import com.example.bank_service_graphql.service.model.BankAccount;
import com.example.bank_service_graphql.service.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements IBankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BankAccountDto> getAllBankAccounts() {
        return bankAccountRepository.findAll().stream()
                .map(ba -> modelMapper.map(ba, BankAccountDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BankAccountDto getBankAccountByRib(String rib) {
        return bankAccountRepository.findByRib(rib)
                .map(ba -> modelMapper.map(ba, BankAccountDto.class))
                .orElseThrow(() -> new BusinessException(String.format("No Bank Account with rib %s found", rib)));
    }

    @Override
    public AddBankAccountResponse saveBankAccount(AddBankAccountRequest dto) {
        if (bankAccountRepository.findByRib(dto.getRib()).isPresent()) {
            throw new BusinessException(String.format("Bank Account with rib %s already exists", dto.getRib()));
        }

        Customer customer = customerRepository.findByIdentityRef(dto.getCustomerIdentityRef())
                .orElseThrow(() -> new BusinessException(String.format("No customer with identity %s found", dto.getCustomerIdentityRef())));

        BankAccount bankAccount = modelMapper.map(dto, BankAccount.class);
        bankAccount.setCustomer(customer);
        bankAccount.setCreatedAt(new Date());
        bankAccount.setAccountStatus(AccountStatus.OPENED);

        BankAccount saved = bankAccountRepository.save(bankAccount);

        AddBankAccountResponse response = modelMapper.map(saved, AddBankAccountResponse.class);
        response.setMessage("Bank Account created successfully");
        return response;
    }
}
