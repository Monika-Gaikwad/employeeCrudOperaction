package com.example.employeeCrudOperactionTest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeCrudOperactionTest.Entity.Employee;
import com.example.employeeCrudOperactionTest.Repository.EmployeeRepo;

@RestController
public class EmployeeService {
	
	
	@Autowired
	EmployeeRepo employeeRepo;

//Save Employee
	public boolean Registerset(Employee employee)
	{
		/*Register r=registerRepository.save(employee);
		if(r!=null)
		{
		
			return true;
		}
		else
		{
			return false;
		}*/
		
		return employeeRepo.save(employee)!=null?true:false;
	}

	
//Delete Record	
	public String deletebyEmployeeId(Long id)
	{
		Optional<Employee> o=employeeRepo.findById(id);
		if(o.isPresent())
		{
			employeeRepo.deleteById(id);
			return "Data Deleted Successfully";
		}
		else
		{
			return "Not Deleted";
		}
		
		
		
	}

//Find All Employee
	public List<Employee> getAllDetails(){
		return this.employeeRepo.findAll();
	}
	
	
//Update Record
	public Employee updateEmployee( Long id, Employee employee)
	{
		Employee existingEmployee=employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found Withe Id : "+id));
		existingEmployee.setName(employee.getName());
		existingEmployee.setSal(employee.getSal());
		return employeeRepo.save(existingEmployee);
	}
	

//	find  by id
     public  Employee getEmployeeById(Long id) 
     {
    	  Optional<Employee> o=employeeRepo.findById(id);
    	  if(o.isPresent())
    	  {
    		 return o.get();
    	  }
    	  else
    	  {
    		  return null;
    	  }
    	  
     }
	

	
}
