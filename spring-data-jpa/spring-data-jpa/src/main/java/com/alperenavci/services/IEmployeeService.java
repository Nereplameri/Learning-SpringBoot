package com.alperenavci.services;

import java.util.List;

import com.alperenavci.dto.DtoEmployee;

public interface IEmployeeService {
	public List<DtoEmployee> findAllEmployees();
}
