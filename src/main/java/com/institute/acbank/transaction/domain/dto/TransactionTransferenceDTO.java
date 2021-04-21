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
public class TransactionTransferenceDTO {

	private String originAgency;
	private String originClientName;
	@Enumerated(EnumType.STRING)
	private TypeAccount originTypeAccount;

	private String destinyAgency;
	private String destinyClientName;
	@Enumerated(EnumType.STRING)
	private TypeAccount destinyTypeAccount;

	private Double value;

	private LocalDateTime date;

	private String description;

}
