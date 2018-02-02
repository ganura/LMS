package com.lms.controller.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.models.Book;
import com.lms.models.Employee;
import com.lms.service.EmployeeService;
import com.lms.service.LmsService;

@RestController
public class MainRestController {
	
	@Autowired
	private LmsService lmsService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/anurag")
	public String anurag() {
		return "Hello Anurag!";
	}
	
	@GetMapping("/findAllBooks")
	public Collection<Book> getAllBooks(){
		return lmsService.findAllBooks();
	}
	/*
	@GetMapping("/deleteBook")
	public void delete(@RequestParam long id) {
		lmsService.deleteBook(id);
		
	}*/
	
	@GetMapping("/findAllEmployees")
	public Collection<Employee> getAllEmployees(){
		return employeeService.findAllEmployees();
	}

}
