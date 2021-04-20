package com.institute.acbank.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.acbank.account.domain.Account;
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
		// verificar se todos os campos estão presentes

		this.transactionRepository.save(transaction);

		return null;
	}

	@Override
	public TransactionDepositDTO deposit(Transaction transaction) {
		TransactionUtils.checkDepositTransaction(transaction);

		Account account = accountRepository.findByNumberAndAgencyAndTypeAccount(transaction.getDestinyAccount(),
				transaction.getDestinyAgency(), transaction.getDestinyTypeAccount()).orElseThrow(() -> {
					throw new RuntimeException("Nenhuma conta foi encontrada com os dados informados");
				});

		if (account.getBalance() < 0) {
			Long valueWithTax = (long) (transaction.getValue() - account.getBalance() * 1.005);
			account.setBalance(account.getBalance() + valueWithTax);
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
		return null;
	}

	@Override
	public Transaction getStatement(Long transactionId) {
		return null;
	}

}
