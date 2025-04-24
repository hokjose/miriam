package com.jhm.jhmregistryservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JhmRegistryServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(JhmRegistryServicioApplication.class, args);
	}

}
