package com.institute.acbank.account.domain;

import java.io.Serializable;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.institute.acbank.client.domain.Client;
import com.institute.acbank.enums.TypeAccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

	private static final long serialVersionUID = 1029862922768388026L;

	@Transient
	Random rand = new Random();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer number = rand.nextInt(999999);

	private String agency;

	@ManyToOne
	private Client client;

	private Double balance = 0.0;

	@Enumerated(EnumType.STRING)
	private TypeAccount typeAccount;

}
