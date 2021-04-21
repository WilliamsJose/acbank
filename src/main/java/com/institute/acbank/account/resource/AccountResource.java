package com.institute.acbank.account.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.institute.acbank.account.domain.Account;
import com.institute.acbank.account.domain.dto.AccountDTO;
import com.institute.acbank.account.service.AccountServiceImpl;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

	@Autowired
	AccountServiceImpl service;

	@PostMapping
	public void createAccount(@Valid @RequestBody Account account) {
		this.service.createAccount(account);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAccount(@PathVariable("id") Long id) {
		this.service.deleteAccount(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{cpfcnpj}")
	public ResponseEntity<List<AccountDTO>> getAccountByCpfCnpj(@PathVariable("cpfcnpj") String cpfcnpj) {

		return ResponseEntity.ok(this.service.getAccountByClientCpfCnpj(cpfcnpj));
	}

}
