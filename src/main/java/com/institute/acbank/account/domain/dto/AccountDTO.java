package com.institute.acbank.account.domain.dto;

import com.institute.acbank.client.domain.Client;
import com.institute.acbank.enums.TypeAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

	private Integer number;

	private String agency;

	private Client client;

	private TypeAccount typeAccount;
}
