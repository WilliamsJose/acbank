package com.institute.acbank.client.service;

import java.util.List;

import com.institute.acbank.client.domain.Client;
import com.institute.acbank.client.domain.dto.ClientDTO;

public interface ClientService {
	// contratos
	ClientDTO createClient(Client client);

	public ClientDTO getClientByCpfCnpj(String cpfcnpj);

	List<Client> getAllClients();
}
