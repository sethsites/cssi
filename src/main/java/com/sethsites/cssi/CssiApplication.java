package com.sethsites.cssi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.sethsites.cssi"})
public class CssiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CssiApplication.class, args);
	}
}
