package com.example.bank_service_graphql.service;


import lombok.AllArgsConstructor;
import com.example.bank_service_graphql.common.CommonTools;
import com.example.bank_service_graphql.dao.BankAccountRepository;
import com.example.bank_service_graphql.dao.BankAccountTransactionRepository;
import com.example.bank_service_graphql.dao.UserRepository;
import com.example.bank_service_graphql.dtos.transaction.*;
import com.example.bank_service_graphql.enums.AccountStatus;
import com.example.bank_service_graphql.enums.TransactionType;
import com.example.bank_service_graphql.service.exception.BusinessException;
import com.example.bank_service_graphql.service.model.BankAccount;
import com.example.bank_service_graphql.service.model.BankAccountTransaction;
import com.example.bank_service_graphql.service.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TransactionServiceImpl implements ITransactionService {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountTransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CommonTools commonTools;

    @Override
    public AddWirerTransferResponse wiredTransfer(AddWirerTransferRequest dto) {
        BankAccount fromAccount = bankAccountRepository.findByRib(dto.getRibFrom())
                .orElseThrow(() -> new BusinessException("Sender account not found"));

        BankAccount toAccount = bankAccountRepository.findByRib(dto.getRibTo())
                .orElseThrow(() -> new BusinessException("Receiver account not found"));

        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new BusinessException("User not found"));

        // Règles de gestion
        if (fromAccount.getAccountStatus() != AccountStatus.OPENED || toAccount.getAccountStatus() != AccountStatus.OPENED) {
            throw new BusinessException("One of the accounts is not OPENED");
        }
        if (fromAccount.getAmount() < dto.getAmount()) {
            throw new BusinessException("Insufficient balance");
        }

        // Mise à jour des soldes
        fromAccount.setAmount(fromAccount.getAmount() - dto.getAmount());
        toAccount.setAmount(toAccount.getAmount() + dto.getAmount());

        bankAccountRepository.save(fromAccount);
        bankAccountRepository.save(toAccount);

        // Création des transactions
        BankAccountTransaction debit = BankAccountTransaction.builder()
                .amount(dto.getAmount())
                .transactionType(TransactionType.DEBIT)
                .bankAccount(fromAccount)
                .user(user)
                .createdAt(new Date())
                .build();

        BankAccountTransaction credit = BankAccountTransaction.builder()
                .amount(dto.getAmount())
                .transactionType(TransactionType.CREDIT)
                .bankAccount(toAccount)
                .user(user)
                .createdAt(new Date())
                .build();

        transactionRepository.save(debit);
        transactionRepository.save(credit);

        return AddWirerTransferResponse.builder()
                .message("Transfer successful")
                .transactionFrom(modelMapper.map(debit, TransactionDto.class))
                .transactionTo(modelMapper.map(credit, TransactionDto.class))
                .build();
    }

    @Override
    public List<TransactionDto> getTransactions(GetTransactionListRequest dto) {
        try {
            Date dateFrom = commonTools.stringToDate(dto.getDateFrom());
            Date dateTo = commonTools.stringToDate(dto.getDateTo());

            return transactionRepository.findByBankAccount_RibAndCreatedAtBetween(dto.getRib(), dateFrom, dateTo)
                    .stream()
                    .map(t -> modelMapper.map(t, TransactionDto.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new BusinessException("Error parsing dates: " + e.getMessage());
        }
    }
}
