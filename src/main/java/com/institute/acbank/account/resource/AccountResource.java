package com.institute.acbank.account.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.institute.acbank.account.domain.Account;
import com.institute.acbank.account.service.AccountServiceImpl;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

	@Autowired
	AccountServiceImpl service;

//	@GetMapping
//	public ResponseEntity<List<ClientDTO>> getClientAccount(Client client) {
//		return ResponseEntity.ok(ClientConverterDTO.convertClientsToDTO(this.service.getAllClients()));
//	}

	@PostMapping
	public void createAccount(@Valid @RequestBody Account account) {
		this.service.createAccount(account);
	}

}
