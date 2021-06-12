package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.WorkTypeService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.WorkTypeDao;
import com.javareact.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService{

	private WorkTypeDao worktypeDao;
@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		super();
		this.worktypeDao = workTypeDao;
	}
@Override
public Result add(WorkType workType) {
this.worktypeDao.save(workType);
return new SuccessResult("worktype added");
}
@Override
public DataResult<List<WorkType>> getAll() {
	return new SuccessDataResult<List<WorkType>>(this.worktypeDao.findAll());
}
	
	
	
	
}
