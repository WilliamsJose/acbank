package com.institute.acbank.client.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.institute.acbank.client.domain.Client;
import com.institute.acbank.client.domain.dto.ClientConverterDTO;
import com.institute.acbank.client.domain.dto.ClientDTO;
import com.institute.acbank.client.service.ClientServiceImpl;

@RestController
@RequestMapping("/clients")
public class ClientResource {

	@Autowired
	ClientServiceImpl service;

	@GetMapping
	public ResponseEntity<List<ClientDTO>> getAllClients() {
		return ResponseEntity.ok(ClientConverterDTO.convertClientsToDTO(this.service.getAllClients()));
	}

	@PutMapping
	public ResponseEntity<ClientDTO> updateClientById(@RequestBody Client client,
			@RequestParam("cpfcnpj") String cpfcnpj) {

		this.service.updateClient(client, cpfcnpj);

		return ResponseEntity.created(URI.create("/clients/" + client.getName())).build();

	}

	@GetMapping("/{cpfcnpj}")
	public ResponseEntity<ClientDTO> getClientByCpfCnpj(@PathVariable("cpfcnpj") String cpfcnpj) {

		return ResponseEntity.ok(this.service.getClientByCpfCnpj(cpfcnpj));
	}

	@PostMapping
	public ResponseEntity<ClientDTO> createClient(@Valid @RequestBody Client client) {
		return ResponseEntity.ok(this.service.createClient(client));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteClient(@PathVariable("id") Long id) {
		this.service.deleteClient(id);

		return ResponseEntity.noContent().build();
	}
}
