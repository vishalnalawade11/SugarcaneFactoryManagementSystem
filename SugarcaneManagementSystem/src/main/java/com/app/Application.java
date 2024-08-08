package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.dto.PurchaseDto;
import com.app.entity.Purchase;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public ModelMapper mapper() {
//		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
//				.setPropertyCondition(Conditions.isNotNull());
//		return modelMapper;
//	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Purchase, PurchaseDto>() {
			@Override
			protected void configure() {
				map(source.getFarmer().getAadharNumber(), destination.getAadharNumber());
			}
		});
		return modelMapper;
	}
}
