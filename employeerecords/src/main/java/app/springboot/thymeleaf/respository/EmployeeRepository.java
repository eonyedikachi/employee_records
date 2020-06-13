package app.springboot.thymeleaf.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.springboot.thymeleaf.pojo.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
