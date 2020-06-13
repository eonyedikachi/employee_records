package app.springboot.thymeleaf.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.springboot.thymeleaf.pojo.Employee;
import app.springboot.thymeleaf.respository.EmployeeRepository;
import app.springboot.thymeleaf.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired private EmployeeRepository employeeRespository;

	@Override
	public List<Employee> getAllEmployees(){
		return (List<Employee>) employeeRespository.findAll();
	}

}
