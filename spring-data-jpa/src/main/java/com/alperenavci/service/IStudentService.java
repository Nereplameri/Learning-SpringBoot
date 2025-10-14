package com.alperenavci.service;

import java.util.List;

import com.alperenavci.entites.Student;

public interface IStudentService {
	public Student saveStudent(Student student);
	public List<Student> getAllStudents();
	public Student getStudentById(Integer id);
}