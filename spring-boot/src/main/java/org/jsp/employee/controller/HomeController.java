package org.jsp.employee.controller;

import java.util.Optional;

import org.jsp.employee.dao.EmployeeDao;
import org.jsp.employee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
@Autowired
	private EmployeeDao edao;

@PostMapping("/slice")
  public Employee saveEmployee (@RequestBody Employee emps) {
	  return edao.saveEmployee(emps);
  }
@PutMapping("/slice")
public Employee updateEmployee (@RequestBody Employee emps) {
	return edao.updateEmployee(emps);
}
@GetMapping("/slice/{id}")
public Optional<Employee> findById(@PathVariable int id){
	return edao.fetchEmployee(id);
}
	@DeleteMapping("/slice/{id}")
	public void deleteEmployee (@PathVariable int id) {
		edao.deleteEmployee(id);
		System.out.println("Employee deleted successfully");
	}
}
