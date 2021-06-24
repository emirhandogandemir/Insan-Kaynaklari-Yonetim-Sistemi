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

	DataResult<JobAdvert> getById(int id);

	DataResult<List<JobAdvert>> getAll();

	DataResult<List<JobAdvert>> getAllOpenJobAdvertList();

	DataResult<List<JobAdvert>> findAllByOrderByPublishedAt();

	DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id);

	DataResult<List<JobAdvert>> getAllByIsActiveByEmployee();// iş arayan

	DataResult<List<JobAdvert>> getAllByIsActiveByEmployee_False();// admin

	DataResult<List<JobAdvert>> getAllByEmployerId(int employerId);

	DataResult<List<JobAdvert>> getByCityId(int cityId);

	DataResult<List<JobAdvert>> getByWorkTypeId(int workTypeId);
	
	DataResult<List<JobAdvert>> getAllSorted();
	
	DataResult<List<JobAdvert>> getAllPagination(int pageNo);

	Result changeIsActiveByEmployee(int jobAdvertId);

	Result changeIsOpenByEmployer(int jobAdvertId);
	


}
