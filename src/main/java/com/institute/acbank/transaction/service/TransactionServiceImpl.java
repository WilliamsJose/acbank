package com.institute.acbank.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.institute.acbank.account.domain.Account;
import com.institute.acbank.account.exception.AccountExcept;
import com.institute.acbank.account.repository.AccountRepository;
import com.institute.acbank.transaction.domain.Transaction;
import com.institute.acbank.transaction.domain.dto.TransactionConverterDTO;
import com.institute.acbank.transaction.domain.dto.TransactionDepositDTO;
import com.institute.acbank.transaction.domain.dto.TransactionTransferenceDTO;
import com.institute.acbank.transaction.domain.dto.TransactionWithdrawDTO;
import com.institute.acbank.transaction.exception.TransactionExcept;
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
		TransactionUtils.checkTransferTransaction(transaction, accountRepository);

		if (transaction.getDestinyAgency().equals(transaction.getOriginAgency())) {
			this.withdraw(transaction);
			this.deposit(transaction);
		} else {

			Double oldTransactionValue = transaction.getValue();

			transaction.setValue(transaction.getValue() * 1.0001);

			this.withdraw(transaction);

			transaction.setValue(oldTransactionValue);

			this.deposit(transaction);
		}

		return TransactionConverterDTO.convertToTransactionTransferenceDTO(transaction);

	}

	@Override
	public TransactionDepositDTO deposit(Transaction transaction) {
		TransactionUtils.checkDepositTransaction(transaction);

		Account account = accountRepository.findByNumberAndAgencyAndTypeAccount(transaction.getDestinyAccount(),
				transaction.getDestinyAgency(), transaction.getDestinyTypeAccount()).orElseThrow(() -> {
					throw new AccountExcept(HttpStatus.NOT_FOUND, "Account not found");
				});

		Double accountBalance = account.getBalance();
		Double transactionValue = transaction.getValue();

		if (account.getBalance() < 0) {
			Double valueWithTax = transactionValue + accountBalance * 1.005;
			account.setBalance(valueWithTax);
		} else {
			account.setBalance(account.getBalance() + transaction.getValue());
		}

		transaction.setDestinyClientName(account.getClient().getName());
		accountRepository.save(account);
		transactionRepository.save(transaction);
		return TransactionConverterDTO.convertToTransactionDepositDTO(transaction);
	}

	@Override
	public TransactionWithdrawDTO withdraw(Transaction transaction) {

		Account account = accountRepository
				.findByNumberAndAgencyAndTypeAccount(transaction.getOriginAccount(), transaction.getOriginAgency(),
						transaction.getOriginTypeAccount())
				.orElseThrow(() -> new AccountExcept(HttpStatus.NOT_FOUND, "Account not found"));

		if ((account.getBalance() - transaction.getValue()) < Double.valueOf("-999.0")) {
			throw new AccountExcept(HttpStatus.BAD_REQUEST, "Account doesn't have sufficient funds.");
		}

		account.setBalance(account.getBalance() - transaction.getValue());

		transaction.setOriginClientName(account.getClient().getName());
		accountRepository.save(account);
		transactionRepository.save(transaction);

		return TransactionConverterDTO.convertToTransactionWithdrawDTO(transaction);
	}

	@Override
	public Transaction getStatement(Long transactionId) {
		return this.transactionRepository.findById(transactionId).orElseThrow(() -> {
			throw new TransactionExcept(HttpStatus.NOT_FOUND, "Transaction not found.");
		});
	}

}
