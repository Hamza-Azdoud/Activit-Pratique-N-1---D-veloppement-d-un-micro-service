package org.sid.bank_account_service.services;

import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponesDTO;
import org.sid.bank_account_service.entities.BankAccount;

public interface AccountServices {
    public BankAccountResponesDTO addAccount(BankAccountRequestDTO account);

    BankAccountResponesDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
