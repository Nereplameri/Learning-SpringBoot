package com.alperenavci.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperenavci.configuration.DataSource;
import com.alperenavci.configuration.GlobalProperties;

@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {
	
	@Autowired
	private GlobalProperties globalProperties;
	
	@GetMapping("/datasource")
	public DataSource getDataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setPassword(globalProperties.getPassword());
		dataSource.setUrl(globalProperties.getUrl());
		dataSource.setUsername(globalProperties.getUsername());
		return dataSource;
	}
}
