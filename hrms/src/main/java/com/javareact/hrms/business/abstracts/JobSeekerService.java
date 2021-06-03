package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.JobSeeker;
import com.javareact.hrms.entities.dtos.JobSeekerCvDto;

public interface JobSeekerService {
	
	
	Result add(JobSeeker candidate);
	Result update(JobSeeker jobseeker);
	Result delete(int id);
	
	DataResult<JobSeeker> getById(int id);
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getJobseekerByNationalId(String nationalId);
	
	DataResult<JobSeekerCvDto> getJobseekerCVById(int id);
}
