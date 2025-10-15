package com.alperenavci.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperenavci.controller.IEmployeeController;
import com.alperenavci.dto.DtoEmployee;
import com.alperenavci.services.IEmployeeService;


@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController{

	@Autowired
	IEmployeeService employeeService;
	
	@GetMapping(path = "/all")
	@Override
	public List<DtoEmployee> findAllEmployees() {
		return employeeService.findAllEmployees();
	}
	
}
