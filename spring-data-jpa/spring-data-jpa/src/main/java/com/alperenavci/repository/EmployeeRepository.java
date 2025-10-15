package com.alperenavci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alperenavci.entites.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
