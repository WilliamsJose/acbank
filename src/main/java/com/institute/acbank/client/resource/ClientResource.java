package com.institute.acbank.client.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
//	@PutMapping
//	public void updateClientById(@RequestBody Client client, @RequestParam("id") Long id) throws Exception {
//		
//		this.service.getClientByCpfCnpj(id).orElseThrow(
//				() -> new ClientNotFound(HttpStatus.NOT_FOUND, "Client not found")
//		);
//		
//		this.service.save(
//				new Client(id, client.getName(), client.getEmail(), client.getPhone())
//		);
//		
//	}
	
	@GetMapping("/{cpfcnpj}")
	public ResponseEntity<ClientDTO> getClientByCpfCnpj(@PathVariable("cpfcnpj") String cpfcnpj) {
		
		return ResponseEntity.ok(this.service.getClientByCpfCnpj(cpfcnpj));
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> createClient(@Valid @RequestBody Client client) {
		return ResponseEntity.ok(this.service.createClient(client));
	}
	
//	@DeleteMapping("/{id}")
//	public void deleteClient(@PathVariable("id") Long id) {
//		
//		this.clientRepository.findById(id).orElseThrow(
//				() -> new ClientNotFound(HttpStatus.NOT_FOUND, "Client not found")
//		);
//		
//		this.clientRepository.deleteById(id);
//	}
//	
//	@GetMapping("/gmail")
//	public List<Client> getAllClientsWithGmail() {
//		return this.clientRepository.getAllClientsWithGmail();
//	}
}
