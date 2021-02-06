package com.flightinformation;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightInformationApplication.class, args);
	}
	@PostConstruct
	void started() {
	    TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
	}

}
