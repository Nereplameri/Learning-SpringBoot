package com.alperenavci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alperenavci.entites.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
}
