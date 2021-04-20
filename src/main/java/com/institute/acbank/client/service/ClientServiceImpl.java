package com.institute.acbank.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.acbank.client.domain.Client;
import com.institute.acbank.client.domain.dto.ClientConverterDTO;
import com.institute.acbank.client.domain.dto.ClientDTO;
import com.institute.acbank.client.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	// service é a ponte entre resource e repository
	public ClientDTO createClient(Client client) {
		try {
			this.clientRepository.save(client);	
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException();
		}
		
		return ClientConverterDTO.convertToClientDTO(client);
	}
	
	public ClientDTO getClientByCpfCnpj(String cpfcnpj) {
		try {
			return ClientConverterDTO.convertToClientDTO(this.clientRepository.findBycpfcnpj(cpfcnpj));
		} catch (Exception e) {
			throw new RuntimeException("Cliente não encontrado.");
		}
	};

	@Override
	public List<Client> getAllClients() {
		return this.clientRepository.findAll();
	}

}
