package com.institute.acbank.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {

	private static ModelMapper modelMapper;

	@Bean
	public static ModelMapper modelMapper() {
		if (ModelMapperUtil.modelMapper == null) {
			ModelMapperUtil.modelMapper = new ModelMapper();
			return ModelMapperUtil.modelMapper;
		}
		return ModelMapperUtil.modelMapper;
	}

}
