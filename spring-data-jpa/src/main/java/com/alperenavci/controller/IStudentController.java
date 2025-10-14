package com.alperenavci.controller;

import java.util.List;

import com.alperenavci.entites.Student;

public interface IStudentController {
	public Student saveStudent(Student student);
	public List<Student> getAllStudents();
}
