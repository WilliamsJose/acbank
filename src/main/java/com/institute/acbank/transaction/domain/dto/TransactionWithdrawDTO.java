package com.institute.acbank.transaction.domain.dto;

import java.time.LocalDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.institute.acbank.enums.TypeAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionWithdrawDTO {

	private String originAgency;
	private String originClientName;
	@Enumerated(EnumType.STRING)
	private TypeAccount originTypeAccount;

	private Double value;

	private LocalDateTime date;
}
