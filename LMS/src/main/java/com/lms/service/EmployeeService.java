package com.lms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.EmployeeRepository;
import com.lms.models.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Collection<Employee> findAllEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		
		for(Employee employee : employeeRepository.findAll()) {
			employees.add(employee);
		}
		
		return employees;
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.delete(id);
	}
	
	public Employee findOne(long id) {
		return employeeRepository.findOne(id);
	}
	
	public void save(Employee emp) {
		employeeRepository.save(emp);
	}
	
	public void delete(long id) {
		employeeRepository.delete(id);
	}
	

}
