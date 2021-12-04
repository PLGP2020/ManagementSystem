package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@SpringBootApplication
public class TravelAgencyManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyManagmentSystemApplication.class, args);

	}

	@Bean
	public HttpFirewall allowUrlSemicolonHttpFirewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowUrlEncodedDoubleSlash(true);
		return firewall;
	}

}
