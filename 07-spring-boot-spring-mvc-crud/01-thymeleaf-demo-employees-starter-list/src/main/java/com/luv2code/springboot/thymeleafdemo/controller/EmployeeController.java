package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService){
		employeeService = theEmployeeService;
	}
	private List<Employee> theEmployees;


	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model
		List<Employee> theEmployees = employeeService.findAll();

		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return("employees/employee-form");
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

		employeeService.save(theEmployee);

		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showForUpdate(@RequestParam("employeeId") int theId, Model theModel){

		//get employee from the service
		Employee theEmployee = employeeService.findById(theId);

		//set employee
		theModel.addAttribute("employee", theEmployee);

		//send over to our form

		return "employees/employee-form";
	}

	@GetMapping("delete")
	public String delete(@RequestParam("employeeId") int theId){

		//delete employee
		employeeService.deleteById(theId);

		//redirect
		return "redirect:/employees/list";
	}
}









