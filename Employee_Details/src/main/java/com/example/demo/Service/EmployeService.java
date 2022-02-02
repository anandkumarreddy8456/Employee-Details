package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.domain.Employee;

@Service
public class EmployeService {
	
	@Autowired
	private EmployeeRepository employerepository;
	
	public List<Employee> allemployee(){
		return employerepository.findAll();
	}
	public Employee getOne(Long id) {
		return employerepository.findById(id).get();
	}
	public void saveemployedetails(Employee employee) {
		employerepository.save(employee);
	}
	public void deleteemployeedetails(Long id) {
		employerepository.deleteById(id);
	}
}
