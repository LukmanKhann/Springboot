package org.jsp.employee.dao;

import java.util.Optional;

import org.jsp.employee.dto.Employee;
import org.jsp.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepository emprepo;
	
	
	public Employee saveEmployee (Employee emp) {
		return emprepo.save(emp);
	}

	public Employee updateEmployee(Employee emp) {
		return emprepo.save(emp);
	}
	public Optional<Employee> fetchEmployee(@PathVariable int id) {
		return emprepo.findById(id);
	}
	public void deleteEmployee( int id) {
	 emprepo.deleteById(id);
	}
	

}
