package com.alperenavci.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.alperenavci.configuration.GlobalProperties;
@EntityScan(basePackages = {"com.alperenavci"})
@ComponentScan(basePackages = {"com.alperenavci"})
@EnableJpaRepositories(basePackages = {"com.alperenavci"})
@EnableConfigurationProperties(value = GlobalProperties.class)

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
