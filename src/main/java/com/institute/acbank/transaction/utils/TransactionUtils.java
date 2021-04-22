package com.institute.acbank.transaction.utils;

import org.springframework.http.HttpStatus;

import com.institute.acbank.account.exception.AccountExcept;
import com.institute.acbank.account.repository.AccountRepository;
import com.institute.acbank.transaction.domain.Transaction;

public class TransactionUtils {

	public static void checkDepositTransaction(Transaction transaction) {
		if (transaction.getDestinyAccount() == null || transaction.getDestinyAgency() == null
				|| transaction.getDestinyTypeAccount() == null || transaction.getValue() <= 0) {

			throw new RuntimeException("É necessário informar todos os dados requisitados.");

		}
	}

	public static void checkTransferTransaction(Transaction transaction, AccountRepository accountRepository) {
		accountRepository.findByNumberAndAgencyAndTypeAccount(transaction.getOriginAccount(),
				transaction.getOriginAgency(), transaction.getOriginTypeAccount()).orElseThrow(() -> {
					throw new AccountExcept(HttpStatus.NOT_FOUND, "Account not found");
				});
		accountRepository.findByNumberAndAgencyAndTypeAccount(transaction.getDestinyAccount(),
				transaction.getDestinyAgency(), transaction.getDestinyTypeAccount()).orElseThrow(() -> {
					throw new AccountExcept(HttpStatus.NOT_FOUND, "Account not found");
				});
	}

}
