package app.springboot.thymeleaf.service;

import java.util.List;

import app.springboot.thymeleaf.pojo.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

}
