package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.WorkHour;

public interface WorkHourService {

	Result add(WorkHour workHour);
	
	DataResult<List<WorkHour>> getAll();
}
