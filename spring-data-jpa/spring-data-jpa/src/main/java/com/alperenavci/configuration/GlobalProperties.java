package com.alperenavci.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component // konfigürasyon bazlı beans oluşturur. 
@Data
public class GlobalProperties {
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.application.name}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
}
