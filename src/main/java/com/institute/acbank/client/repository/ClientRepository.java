package com.institute.acbank.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.institute.acbank.client.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findBycpfcnpj(String cpfcnpj);

}
