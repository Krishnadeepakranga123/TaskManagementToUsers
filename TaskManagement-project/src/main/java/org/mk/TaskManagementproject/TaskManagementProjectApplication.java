package org.mk.TaskManagementproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskManagementProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementProjectApplication.class, args);
	}
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
