package org.sid.bank_account_service.services;

import org.sid.bank_account_service.Repositories.BankAccountRepository;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponesDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServicesImpl implements AccountServices {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;


    @Override
    public BankAccountResponesDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();


        BankAccount savebankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponesDTO bankAccountResponesDTO = accountMapper.fromBankAccount(savebankAccount);
        return bankAccountResponesDTO;
    }

    @Override
    public BankAccountResponesDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();


        BankAccount savebankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponesDTO bankAccountResponesDTO = accountMapper.fromBankAccount(savebankAccount);
        return bankAccountResponesDTO;
    }

}
