package app.springboot.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.springboot.thymeleaf.pojo.Employee;
import app.springboot.thymeleaf.service.EmployeeService;

@Controller
public class EmployeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String employees(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", new Employee());
		model.addAttribute("title", "Employees");
		model.addAttribute("isAdd", true);

		// return view in Thymeleaf template folder
		return "view/employees";
	}

	@PostMapping(value = "/save")
	public String save(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes, Model model) {
		Employee dbEmployee = employeeService.save(employee);
		if (dbEmployee != null) {
			redirectAttributes.addFlashAttribute("successmessage", "Employee record saved successfully.");
			return "redirect:/";
		} else {
			model.addAttribute("errormessage", "Employee record not save, please try again.");
			model.addAttribute("employee", employee);
			return "view/employees";
		}
	}

	@PostMapping(value = "/update")
	public String update(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes, Model model) {
		Employee dbEmployee = employeeService.update(employee);
		if (dbEmployee != null) {
			redirectAttributes.addFlashAttribute("successmessage", "Employee record updated successfully.");
			return "redirect:/";
		} else {
			model.addAttribute("errormessage", "Employee record not updated, please try again.");
			model.addAttribute("employee", employee);
			return "view/employees";
		}
	}

	@GetMapping(value = "/getEmployee/{id}")
	public String getEmployee(@PathVariable Long id, Model model) {
		Employee employee = employeeService.findById(id);
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", employee);
		model.addAttribute("title", "Edit Employee");
		model.addAttribute("isAdd", false);
		return "view/employees";
	}

	@GetMapping(value = "/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAtrributes) {
		employeeService.delete(id);
		redirectAtrributes.addFlashAttribute("successmessage", "Employee record deleted successfully.");
		return "redirect:/";
	}
}
