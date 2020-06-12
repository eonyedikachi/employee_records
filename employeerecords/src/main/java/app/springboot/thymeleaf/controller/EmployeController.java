package app.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeController {
	
	@GetMapping("/")
	public String employees(Model model) {
		return null;
	}
	
}
