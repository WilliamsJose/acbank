package com.institute.acbank.transaction.service;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.acbank.account.domain.Account;
import com.institute.acbank.account.exception.AccountNotFound;
import com.institute.acbank.account.repository.AccountRepository;
import com.institute.acbank.transaction.domain.Transaction;
import com.institute.acbank.transaction.domain.dto.TransactionConverterDTO;
import com.institute.acbank.transaction.domain.dto.TransactionDepositDTO;
import com.institute.acbank.transaction.domain.dto.TransactionTransferenceDTO;
import com.institute.acbank.transaction.domain.dto.TransactionWithdrawDTO;
import com.institute.acbank.transaction.repository.TransactionRepository;
import com.institute.acbank.transaction.utils.TransactionUtils;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Override
	public TransactionTransferenceDTO transfer(Transaction transaction) {
//		if (transaction.getDestinyAgency().equals(transaction.getOriginAgency())) {
//			
//		}

		return null;
	}

	@Override
	public TransactionDepositDTO deposit(Transaction transaction) {
		DecimalFormat df = new DecimalFormat("0,00");
		
		TransactionUtils.checkDepositTransaction(transaction);

		Account account = accountRepository.findByNumberAndAgencyAndTypeAccount(transaction.getDestinyAccount(),
				transaction.getDestinyAgency(), transaction.getDestinyTypeAccount()).orElseThrow(() -> {
					throw new RuntimeException("Nenhuma conta foi encontrada com os dados informados");
				});
		
		Double accountBalance = Double.parseDouble(df.format(account.getBalance()));
		Double transactionValue = Double.parseDouble(df.format(transaction.getValue()));

		if (account.getBalance() < 0) {
			Double valueWithTax = Double.parseDouble(df.format(transactionValue + accountBalance * 1.005));
			account.setBalance(valueWithTax);
			transaction.setDestinyClientName(account.getClient().getName());
			accountRepository.save(account);
			transactionRepository.save(transaction);
			return TransactionConverterDTO.convertToTransactionDepositDTO(transaction);
		}

		account.setBalance(account.getBalance() + transaction.getValue());
		transaction.setDestinyClientName(account.getClient().getName());
		accountRepository.save(account);
		transactionRepository.save(transaction);
		return TransactionConverterDTO.convertToTransactionDepositDTO(transaction);
	}

	@Override
	public TransactionWithdrawDTO withdraw(Transaction transaction) {

		Account account = accountRepository.findByNumberAndAgencyAndTypeAccount(transaction.getOriginAccount(),
				transaction.getOriginAgency(), transaction.getOriginTypeAccount())
				.orElseThrow(() -> new AccountNotFound("Account not found"));

		account.setBalance(account.getBalance() - transaction.getValue());
		
		transaction.setOriginClientName(account.getClient().getName());
		accountRepository.save(account);
		transactionRepository.save(transaction);
		
		return TransactionConverterDTO.convertToTransactionWithdrawDTO(transaction);
	}

	@Override
	public Transaction getStatement(Long transactionId) {
		return null;
	}

}
