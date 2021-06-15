package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Employee;



public interface EmployeeService {
	
	
	Result add(Employee employee);
	Result update(Employee employee);
	Result delete(int id);
	DataResult<Employee> getById(int id);
	
	DataResult<List<Employee>> getAll();


	
}
