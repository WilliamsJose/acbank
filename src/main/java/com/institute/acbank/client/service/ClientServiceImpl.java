package com.institute.acbank.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.institute.acbank.client.domain.Client;
import com.institute.acbank.client.domain.dto.ClientConverterDTO;
import com.institute.acbank.client.domain.dto.ClientDTO;
import com.institute.acbank.client.exception.ClientExcept;
import com.institute.acbank.client.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public ClientDTO createClient(Client client) {
		try {
			this.clientRepository.save(client);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(iae.getMessage(), iae);
		}

		return ClientConverterDTO.convertToClientDTO(client);
	}

	public ClientDTO getClientByCpfCnpj(String cpfcnpj) {
		return ClientConverterDTO.convertToClientDTO(this.clientRepository.findBycpfcnpj(cpfcnpj)
				.orElseThrow(() -> new ClientExcept(HttpStatus.NOT_FOUND, "Client not found")));
	};

	public void updateClient(Client client, String cpfcnpj) {
		this.getClientByCpfCnpj(cpfcnpj);

		try {
			this.clientRepository.save(client);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(iae.getMessage(), iae);
		}
	}

	public void deleteClient(Long id) {
		this.clientRepository.findById(id)
				.orElseThrow(() -> new ClientExcept(HttpStatus.NOT_FOUND, "Client not found"));

		this.clientRepository.deleteById(id);
	}

	@Override
	public List<Client> getAllClients() {
		return this.clientRepository.findAll();
	}

}
