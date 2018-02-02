package com.lms.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.models.Book;
import com.lms.models.Employee;
import com.lms.service.EmployeeService;
import com.lms.service.LmsService;

@Controller
public class MainController {
	
	@Autowired
	private LmsService lmsService;
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("books", lmsService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}
	
	@GetMapping("/updateBook")
	public String init(@RequestParam long id,HttpServletRequest req) {
		req.setAttribute("book", lmsService.findOne(id));
		req.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}
	
	@PostMapping("/save")
	public void save(@ModelAttribute Book book,BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res) throws IOException {
		lmsService.save(book);
		req.setAttribute("books", lmsService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		res.sendRedirect("/");
	}
	
	@GetMapping("/newBook")
	public String newBook(HttpServletRequest req) {
		req.setAttribute("mode", "BOOK_NEW");
		return "index";
	}
	
	@GetMapping("/deleteBook")
	public void deleteBook(@RequestParam long id,HttpServletRequest req,HttpServletResponse res) throws IOException {
		lmsService.delete(id);
		req.setAttribute("books", lmsService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		res.sendRedirect("/");
	}
	
	@GetMapping("/employees")
	public String getEmployee(HttpServletRequest req) {
		req.setAttribute("employees", empService.findAllEmployees());
		req.setAttribute("mode", "EMP_VIEW");
		return "index";
	}
	
	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam long id,HttpServletRequest req) {
		req.setAttribute("emp", empService.findOne(id));
		req.setAttribute("mode", "EMP_EDIT");
		return "index";
	}
	
	@GetMapping("/deleteEmployee")
	public void deleteEmployee(@RequestParam long id,HttpServletRequest req,HttpServletResponse res) throws IOException {
		empService.delete(id);
		req.setAttribute("employees", empService.findAllEmployees());
		req.setAttribute("mode", "EMP_VIEW");
		res.sendRedirect("/");
	}
	
	@PostMapping("/saveEmployee")
	public void saveEmployee(@ModelAttribute Employee emp,BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res) throws IOException {
		empService.save(emp);
		req.setAttribute("mode", empService.findAllEmployees());
		req.setAttribute("mode", "EMP_VIEW");
		res.sendRedirect("/");
	}
	
	@GetMapping("/newEmployee")
	public String newEmployee(HttpServletRequest req) {
		req.setAttribute("mode", "EMP_NEW");
		return "index";
	}
	
	

}
