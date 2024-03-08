package com.example.employeeCrudOperactionTest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeeCrudOperactionTest.Entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	//select *from employee where name like '%name%'
	public List<Employee> findByNameContaining(String name);

}
