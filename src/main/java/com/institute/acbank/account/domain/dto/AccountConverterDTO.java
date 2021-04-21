package com.institute.acbank.account.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.institute.acbank.account.domain.Account;
import com.institute.acbank.config.ModelMapperUtil;

public class AccountConverterDTO {
	public static AccountDTO convertToAccountDTO(Account account) {
		return ModelMapperUtil.modelMapper().map(account, AccountDTO.class);
	}

	public static List<AccountDTO> convertAccountsToDTO(List<Account> accounts) {
		return accounts.stream().map(account -> ModelMapperUtil.modelMapper().map(account, AccountDTO.class))
				.collect(Collectors.toList());
	}
}
