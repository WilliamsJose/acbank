package com.institute.acbank.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.institute.acbank.account.domain.Account;
import com.institute.acbank.enums.TypeAccount;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByNumberAndAgencyAndTypeAccount(Integer number, String agency, TypeAccount type);
	
}
