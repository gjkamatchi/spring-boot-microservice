package com.ps.verizon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ps.verizon"})
public class PsVerizonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsVerizonApplication.class, args);
	}

}
