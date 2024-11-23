package org.sid.bank_account_service.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.Repositories.BankAccountRepository;
import org.sid.bank_account_service.Repositories.CustomerRepository;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponesDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.entities.Customer;
import org.sid.bank_account_service.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccounrGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountServices accountServices;
    @Autowired
    private CustomerRepository CustomerRepository;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponesDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountServices.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponesDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountServices.updateAccount(id,bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);

    }
    @QueryMapping
    public List<Customer> customers(){
        return CustomerRepository.findAll();
    }
}
/*
record BankAccountDTO(Double balance, String type, String currency){

}*/