package com.institute.acbank.transaction.utils;

import com.institute.acbank.transaction.domain.Transaction;

public class TransactionUtils {
	
	public static void checkDepositTransaction(Transaction transaction) {
		if (transaction.getDestinyAccount() == null 
				|| transaction.getDestinyAgency() == null
				|| transaction.getDestinyTypeAccount() == null
				|| transaction.getValue() <= 0) {
			
			throw new RuntimeException("É necessário informar todos os dados requisitados.");
			
		}
	}

}
