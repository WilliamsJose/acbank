package com.institute.acbank.transaction.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.institute.acbank.enums.TypeAccount;
import com.institute.acbank.enums.TypeTransaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {
	
	private static final long serialVersionUID = -5296261573394553621L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TypeTransaction typeTransaction;
	
	private String originAgency;
	private String originClientName;
	private Integer originAccount;
	private String origintCpfCnpj;
	@Enumerated(EnumType.STRING)
	private TypeAccount originTypeAccount;
	
	private String destinyAgency;
	private String destinyClientName;
	private Integer destinyAccount;
	private String destinyCpfCnpj;
	@Enumerated(EnumType.STRING)
	private TypeAccount destinyTypeAccount;
	
	private Long value;
	
	private LocalDateTime dateTime = LocalDateTime.now();
	
	private String description;
	
}
