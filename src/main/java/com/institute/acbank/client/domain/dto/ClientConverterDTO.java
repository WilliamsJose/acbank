package com.institute.acbank.client.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.institute.acbank.client.domain.Client;
import com.institute.acbank.config.ModelMapperUtil;

public class ClientConverterDTO {

	public static ClientDTO convertToClientDTO(Client client) {
		return ModelMapperUtil.modelMapper().map(client, ClientDTO.class);
	}
	
	public static List<ClientDTO> convertClientsToDTO(List<Client> clients) {
		return clients.stream().map(client -> ModelMapperUtil.modelMapper().map(client, ClientDTO.class)).collect(Collectors.toList());
	}
}
