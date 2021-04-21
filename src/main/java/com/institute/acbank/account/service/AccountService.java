package com.institute.acbank.account.service;

import java.util.List;

import com.institute.acbank.account.domain.Account;
import com.institute.acbank.account.domain.dto.AccountDTO;

public interface AccountService {

	AccountDTO createAccount(Account account);

	List<AccountDTO> getAccountByClientCpfCnpj(String cpfcnpj);

	void deleteAccount(Long id);

}
