package com.org.OnlineBusTicketBookingApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@OpenAPIDefinition(
		info = @Info(
				title = "Online Bus Ticket Booking Application Documentation"
		)
)
@SpringBootApplication
public class OnlineBusTicketBookingApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(OnlineBusTicketBookingApplication.class, args);
	}

}
