package com.distributed.systems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DistributedSystemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedSystemsApplication.class, args);
	}

}
