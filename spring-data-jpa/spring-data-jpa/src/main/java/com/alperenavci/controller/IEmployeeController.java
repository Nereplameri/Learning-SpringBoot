package com.alperenavci.controller;

import java.util.List;

import com.alperenavci.dto.DtoEmployee;

public interface IEmployeeController {
	public List<DtoEmployee> findAllEmployees();
}
