package app.springboot.thymeleaf.service;

import java.util.List;

import app.springboot.thymeleaf.pojo.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee save(Employee employee);

	Employee findById(Long id);
	Employee update(Employee employee);

	void delete(Long id);
}
