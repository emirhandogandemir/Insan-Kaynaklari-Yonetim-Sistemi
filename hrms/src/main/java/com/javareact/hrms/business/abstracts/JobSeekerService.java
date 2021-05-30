package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker candidate);
//	Result update(Jobseeker jobseeker);
//	Result delete(int id);
//	DataResult<Jobseeker> getById(int id);
	
	DataResult<JobSeeker> getJobseekerByNationalId(String nationalId);
}
