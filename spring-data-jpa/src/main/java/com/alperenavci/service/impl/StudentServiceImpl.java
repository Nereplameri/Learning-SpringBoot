package com.alperenavci.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenavci.entites.Student;
import com.alperenavci.repository.StudentRepository;
import com.alperenavci.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
}