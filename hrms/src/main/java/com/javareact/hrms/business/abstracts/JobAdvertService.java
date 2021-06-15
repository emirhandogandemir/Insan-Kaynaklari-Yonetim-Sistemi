package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.JobAdvert;
import com.javareact.hrms.entities.dtos.JobAdvertDto;


public interface JobAdvertService {
	Result add(JobAdvertDto jobAdvertDto);
	Result update(JobAdvert jobAdvert);
	Result delete(int id);
	Result changeOpenToClose(int id);
	DataResult<JobAdvert> getById(int id);	
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getAllOpenJobAdvertList();
	DataResult<List<JobAdvert>> findAllByOrderByPublishedAt();
	DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id);
}
