package org.sid.bank_account_service.mappers;

import org.sid.bank_account_service.dto.BankAccountResponesDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponesDTO fromBankAccount(final BankAccount bankAccount) {
        BankAccountResponesDTO bankAccountResponesDTO = new BankAccountResponesDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponesDTO);
        return bankAccountResponesDTO;
    }
}
