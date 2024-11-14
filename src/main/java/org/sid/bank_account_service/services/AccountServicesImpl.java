package org.sid.bank_account_service.services;

import org.sid.bank_account_service.Repositories.BankAccountRepository;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponesDTO;
import org.sid.bank_account_service.entities.BankAccount;
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

    @Override
    public BankAccountResponesDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balence(bankAccountDTO.getBalence())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();


        BankAccount savebankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponesDTO bankAccountResponesDTO = BankAccountResponesDTO.builder()
                .id(savebankAccount.getId())
                .createdAt(savebankAccount.getCreatedAt())
                .balence(savebankAccount.getBalence())
                .type(savebankAccount.getType())
                .currency(savebankAccount.getCurrency())
                .build();
        return bankAccountResponesDTO;
    }

}
