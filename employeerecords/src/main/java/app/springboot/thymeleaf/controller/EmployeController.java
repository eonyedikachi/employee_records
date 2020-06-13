package app.springboot.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import app.springboot.thymeleaf.pojo.Employee;
import app.springboot.thymeleaf.service.EmployeeService;

@Controller
public class EmployeController {
	
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("/")
	public String employees(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees",employees);
		model.addAttribute("employee", new Employee());
		model.addAttribute("title", "Employees");
		model.addAttribute("isAdd", true);
		
		// return view in Thymeleaf template folder
		return "view/employees";
	}
	
}
