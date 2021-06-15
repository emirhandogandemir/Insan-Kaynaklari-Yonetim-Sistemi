package com.javareact.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.EmployeeService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Employee;
import com.javareact.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employee employee) {
		return ResponseEntity.ok(this.employeeService.add(employee));
	}

	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Employee employee){
		return ResponseEntity.ok(this.employeeService.update(employee));
	}
	
	@PostMapping("/delete")
	public Result delete(@PathVariable("id") int id){
		return this.employeeService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Employee> getById(@PathVariable("id") int id){
		return this.employeeService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll() {
		return this.employeeService.getAll();
	}
}
