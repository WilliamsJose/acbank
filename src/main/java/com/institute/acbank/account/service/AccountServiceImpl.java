package com.institute.acbank.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.acbank.account.domain.Account;
import com.institute.acbank.account.repository.AccountRepository;
import com.institute.acbank.client.domain.Client;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void createAccount(Account account) {

		this.accountRepository.save(account);

	}

	@Override
	public Account getClientAccount(Client client) {
		return null;
	}

}
