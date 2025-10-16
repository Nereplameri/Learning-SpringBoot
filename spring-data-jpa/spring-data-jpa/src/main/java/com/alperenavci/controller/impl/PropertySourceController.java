package com.alperenavci.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperenavci.configuration.DataSource;
import com.alperenavci.configuration.GlobalProperties;
import com.alperenavci.configuration.Server;

@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {
	
	@Autowired
	private GlobalProperties globalProperties;
	
	@GetMapping("/datasource")
	public DataSource getDataSource() {
		return null;
	}
	
	@GetMapping(value = "/getServers")
	public List<Server> getServers(){
		return globalProperties.getServers();
	}
}
