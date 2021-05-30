package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	
//	Result update(Employer employer);
//	Result delete(int id);
//	DataResult<Employer> getById(int id);
	Result add(Employer employer);
}
