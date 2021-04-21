package com.institute.acbank.transaction.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.institute.acbank.config.ModelMapperUtil;
import com.institute.acbank.transaction.domain.Transaction;

public class TransactionConverterDTO {

	public static TransactionTransferenceDTO convertToTransactionTransferenceDTO(Transaction transaction) {
		return ModelMapperUtil.modelMapper().map(transaction, TransactionTransferenceDTO.class);
	}

	public static List<TransactionTransferenceDTO> convertTransactionsTransferenceToDTO(
			List<Transaction> transactions) {
		return transactions.stream()
				.map(transaction -> ModelMapperUtil.modelMapper().map(transaction, TransactionTransferenceDTO.class))
				.collect(Collectors.toList());
	}

	public static TransactionDepositDTO convertToTransactionDepositDTO(Transaction transaction) {
		return ModelMapperUtil.modelMapper().map(transaction, TransactionDepositDTO.class);
	}

//	public static TransactionDepositDTO convertToTransactionDepositDTO(Transaction transaction) {
//		ModelMapperUtil.modelMapper().getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		TypeMap<Transaction, TransactionDepositDTO> typeMap = ModelMapperUtil.modelMapper().createTypeMap(Transaction.class, TransactionDepositDTO.class);
//		typeMap.addMappings(mapper -> {
//			mapper.map(Transaction::getDestinyAgency, TransactionDepositDTO::setAgency);
//			mapper.map(Transaction::getDestinyClientName, TransactionDepositDTO::setClientName);
//			mapper.map(Transaction::getDestinyTypeAccount, TransactionDepositDTO::setTypeAccount);
//			mapper.map(Transaction::getTypeTransaction, TransactionDepositDTO::setTypeTransaction);
//			mapper.map(Transaction::getValue, TransactionDepositDTO::setValue);
//			mapper.map(Transaction::getDateTime, TransactionDepositDTO::setDateTime);
//		});
//		
//		return ModelMapperUtil.modelMapper().map(typeMap, TransactionDepositDTO.class);
//	}

	public static List<TransactionDepositDTO> convertTransactionsDepositToDTO(List<Transaction> transactions) {
		return transactions.stream()
				.map(transaction -> ModelMapperUtil.modelMapper().map(transaction, TransactionDepositDTO.class))
				.collect(Collectors.toList());
	}

	public static TransactionWithdrawDTO convertToTransactionWithdrawDTO(Transaction transaction) {
		return ModelMapperUtil.modelMapper().map(transaction, TransactionWithdrawDTO.class);
	}

	public static List<TransactionWithdrawDTO> convertTransactionsWithdrawToDTO(List<Transaction> transactions) {
		return transactions.stream()
				.map(transaction -> ModelMapperUtil.modelMapper().map(transaction, TransactionWithdrawDTO.class))
				.collect(Collectors.toList());
	}

}
