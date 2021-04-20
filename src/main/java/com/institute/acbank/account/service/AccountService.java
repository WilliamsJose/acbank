package com.institute.acbank.account.service;

import com.institute.acbank.account.domain.Account;
import com.institute.acbank.client.domain.Client;

public interface AccountService {
	
	Account getClientAccount(Client client);

	void createAccount(Account account); 
	
}
