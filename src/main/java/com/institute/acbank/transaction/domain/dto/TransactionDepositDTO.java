package com.institute.acbank.transaction.domain.dto;

import java.time.LocalDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.institute.acbank.enums.TypeAccount;
import com.institute.acbank.enums.TypeTransaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDepositDTO {

	@Enumerated(EnumType.STRING)
	private TypeTransaction typeTransaction;

	private String destinyAgency;

	private String destinyClientName;

	@Enumerated(EnumType.STRING)
	private TypeAccount destinyTypeAccount;

	private Long value;

	private LocalDateTime dateTime;
}
