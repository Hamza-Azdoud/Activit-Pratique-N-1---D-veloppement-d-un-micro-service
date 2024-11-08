package org.sid.bank_account_service;

import org.sid.bank_account_service.Repositories.BankAccountRepository;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args ->{
			for (int i = 0; i <10 ; i++) {
				//Ajouter des comptes
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random() >0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
						.balence(1000+Math.random()*90000)
						.createdAt(new Date())
						.currency("MAD")
						.build();

				bankAccountRepository.save(bankAccount);
			}
		};
	}
}
