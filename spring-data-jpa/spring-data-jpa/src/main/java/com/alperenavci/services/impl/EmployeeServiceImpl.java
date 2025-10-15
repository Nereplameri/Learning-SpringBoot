package com.alperenavci.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenavci.dto.DtoDepartment;
import com.alperenavci.dto.DtoEmployee;
import com.alperenavci.entites.Employee;
import com.alperenavci.repository.EmployeeRepository;
import com.alperenavci.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<DtoEmployee> findAllEmployees() {
		List<Employee> listDbEmployee = employeeRepository.findAll();
		List<DtoEmployee> dtoEmployees = new ArrayList<>();
		
		// database veri boş kontrolü
		if(listDbEmployee.isEmpty()) {
			return null;
		}
		
		// Gelen listenin elemanlarını (objeleri) dönen for-each
		for (Employee dbEmployee : listDbEmployee) {
			
			DtoEmployee dtoEmp = new DtoEmployee();
			BeanUtils.copyProperties(dbEmployee, dtoEmp);
			// DtoEmployee dtoEmp:
			// 	private Long id; Aktarıldı
			// 	private String name; Aktarıldı
			// 	private DtoDepartment department; <-/-> private Department department;
			// ---------
			// DtoDepartment department 'e veri aktarılamadı...
			// Department department, DTO 'ya çevirilip içerisine aktarılacak
			DtoDepartment dtoDep = new DtoDepartment();
			BeanUtils.copyProperties(dbEmployee.getDepartment(), dtoDep);
			dtoEmp.setDepartment(dtoDep);
			
			dtoEmployees.add(dtoEmp);
		}
		
		return dtoEmployees;
	}

}
