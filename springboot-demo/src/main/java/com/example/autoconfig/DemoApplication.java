package com.example.autoconfig;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.autoconfig.web.servlet")
public class DemoApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoApplication.class)
				.web(WebApplicationType.SERVLET)
				.run(args);
//		SpringApplication.run(DemoApplication.class, args);

	}


}

