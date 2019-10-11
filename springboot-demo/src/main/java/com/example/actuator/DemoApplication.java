package com.example.actuator;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoApplication.class)
				.web(WebApplicationType.SERVLET)
				.run(args);
//		SpringApplication.run(DemoApplication.class, args);

	}


}

