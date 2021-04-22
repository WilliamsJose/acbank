package com.institute.acbank.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.institute.acbank.account.domain.Account;
import com.institute.acbank.account.domain.dto.AccountConverterDTO;
import com.institute.acbank.account.domain.dto.AccountDTO;
import com.institute.acbank.account.exception.AccountExcept;
import com.institute.acbank.account.repository.AccountRepository;
import com.institute.acbank.client.domain.Client;
import com.institute.acbank.client.exception.ClientExcept;
import com.institute.acbank.client.repository.ClientRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ClientRepository clientRepository;

	public AccountDTO createAccount(Account account) {
		try {
			this.accountRepository.save(account);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(iae.getMessage(), iae);
		}

		return AccountConverterDTO.convertToAccountDTO(account);
	}

	public List<AccountDTO> getAccountByClientCpfCnpj(String cpfcnpj) {
		Client client = this.clientRepository.findBycpfcnpj(cpfcnpj)
				.orElseThrow(() -> new ClientExcept(HttpStatus.NOT_FOUND, "Client not found"));

		return AccountConverterDTO.convertAccountsToDTO(this.accountRepository.findByClient(client)
				.orElseThrow(() -> new AccountExcept(HttpStatus.NOT_FOUND, "Account not found")));
	};

	public void deleteAccount(Long id) {
		this.accountRepository.findById(id)
				.orElseThrow(() -> new AccountExcept(HttpStatus.NOT_FOUND, "Account not found"));

		this.accountRepository.deleteById(id);
	}

}
