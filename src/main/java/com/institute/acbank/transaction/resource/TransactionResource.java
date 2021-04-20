package com.institute.acbank.transaction.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.institute.acbank.transaction.domain.Transaction;
import com.institute.acbank.transaction.domain.dto.TransactionDepositDTO;
import com.institute.acbank.transaction.domain.dto.TransactionTransferenceDTO;
import com.institute.acbank.transaction.domain.dto.TransactionWithdrawDTO;
import com.institute.acbank.transaction.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionResource {

	@Autowired
	TransactionService service;

	@PostMapping("/transference")
	public ResponseEntity<TransactionTransferenceDTO> transfer(@Valid @RequestBody Transaction transaction) {
		return ResponseEntity.ok(this.service.transfer(transaction));
	}

	@PostMapping("/deposit")
	public ResponseEntity<TransactionDepositDTO> deposit(@Valid @RequestBody Transaction transaction) {
		return ResponseEntity.ok(this.service.deposit(transaction));
	}

	@PostMapping("/withdraw")
	public ResponseEntity<TransactionWithdrawDTO> withdraw(@Valid @RequestBody Transaction transaction) {
		return ResponseEntity.ok(this.service.withdraw(transaction));
	}

}
