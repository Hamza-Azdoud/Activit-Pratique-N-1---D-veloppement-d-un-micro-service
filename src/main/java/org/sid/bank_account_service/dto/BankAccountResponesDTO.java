package org.sid.bank_account_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.enums.AccountType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BankAccountResponesDTO {
    private String id;
    private Date createdAt;
    private Double balence;
    private String currency;
    private AccountType type;
}
