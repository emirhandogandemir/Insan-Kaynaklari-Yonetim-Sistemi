package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.WorkHourService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.WorkHourDao;
import com.javareact.hrms.entities.concretes.WorkHour;

@Service
public class WorkHourManager implements WorkHourService {

	private WorkHourDao workHourDao;
	
	
	@Autowired
	public WorkHourManager(WorkHourDao workHourDao) {
		super();
		this.workHourDao = workHourDao;
	}

	@Override
	public Result add(WorkHour workHour) {
		this.workHourDao.save(workHour);
		return new SuccessResult("job Seeker Added");
	}

	@Override
	public DataResult<List<WorkHour>> getAll() {
		return new SuccessDataResult<List<WorkHour>>(this.workHourDao.findAll());
	}

}
