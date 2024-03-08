package com.example.employeeCrudOperactionTest.EmployeeController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeCrudOperactionTest.Entity.Employee;
import com.example.employeeCrudOperactionTest.Repository.EmployeeRepo;
import com.example.employeeCrudOperactionTest.Service.EmployeeService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeContol {
	
	List<Employee> list=new ArrayList<Employee>();
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	
	
	@GetMapping(value="/showmsg")
	public String getDetails()
	{
		return "Welcome";
	}

	
	
//add	
	
	@PostMapping( value="/save")
	public String Registerdataadd(@RequestBody Employee employee)
	{
		boolean b= employeeService.Registerset(employee);
		
		if(b)
		{
			return "Record added Success------";
		}
		else
		{
			return "Some Problem is Their-----!";
		}
		
	}

	
//delete
	
	@DeleteMapping(value="/delete/{id}")
	public String deleterecordById(@PathVariable("id") Long id)
	{
		 String msg=employeeService.deletebyEmployeeId(id);
		return msg;
	}


        //get all	
	
	@GetMapping(value="/viewall")
	public List<Employee> getAllUser()
	{
		return employeeService.getAllDetails();
	}
	
	
            //find by Id
	
	@GetMapping("/searchById/{id}")
	public String searchById(@PathVariable("id") Long id)
	{
		Employee e=employeeService.getEmployeeById(id);
		if(e!=null)
		{
			return "Record found : Name - " + e.getName() + ", Salary - " + e.getSal();
		}
		else
		{
			return "Record not found";
		}
	}	
              //Update 
	
	@PutMapping("/{id}")
	public Employee employeeUpdate(@PathVariable Long id,@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(id, employee);
	}
	
	
                //Find By Name
	
 @GetMapping("/search/{emp}")
 public  List<Employee> findByName(@PathVariable("emp") String name)
 {
	 System.out.println("Name is"+name);
	 List<Employee> list=employeeRepo.findByNameContaining(name);
	 return list;
 }
}