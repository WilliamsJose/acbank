package com.institute.acbank.account.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account {
	
	private static final long serialVersionUID = 7903132512215927546L;
	private Double tax;
	
}
