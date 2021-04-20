package com.institute.acbank.transaction.service;

import com.institute.acbank.transaction.domain.Transaction;
import com.institute.acbank.transaction.domain.dto.TransactionDepositDTO;
import com.institute.acbank.transaction.domain.dto.TransactionTransferenceDTO;
import com.institute.acbank.transaction.domain.dto.TransactionWithdrawDTO;

public interface TransactionService {
	
	TransactionTransferenceDTO transfer(Transaction transaction);
	
	TransactionDepositDTO deposit(Transaction transaction);
	
	TransactionWithdrawDTO withdraw(Transaction transaction);

	Transaction getStatement(Long transactionId);

}
