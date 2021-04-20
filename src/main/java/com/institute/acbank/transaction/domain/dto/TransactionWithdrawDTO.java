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

	private String agency;
	private String clientName;
	@Enumerated(EnumType.STRING)
	private TypeAccount typeAccount;

	private Long value;

	private LocalDateTime date;
}
