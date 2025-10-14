package com.alperenavci.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperenavci.controller.IStudentController;
import com.alperenavci.entites.Student;
import com.alperenavci.service.IStudentService;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController{
	
	//Enjekte ederken Interface işaretçisi kullanılır.
	@Autowired
	private IStudentService studentService;
	
	@PostMapping(path = "/save")
	@Override
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	
}