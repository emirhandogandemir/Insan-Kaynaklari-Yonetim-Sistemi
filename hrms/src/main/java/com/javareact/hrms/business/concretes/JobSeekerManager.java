package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.JobSeekerService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.JobseekerDao;
import com.javareact.hrms.entities.concretes.JobSeeker;


@Service
public class JobSeekerManager implements JobSeekerService {
   
private JobseekerDao jobseekerDao;
	
	@Autowired
	public JobSeekerManager(JobseekerDao jobseekerDao) {
		super();
		this.jobseekerDao = jobseekerDao;
	}

	@Override
	public Result add(JobSeeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
      return new SuccessResult("Jobseeker has been added.");
	}
//
//	@Override
//	public Result update(Jobseeker jobseeker) {
//		this.jobseekerDao.save(jobseeker);
//      return new SuccessResult("Jobseeker has been updated.");
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.jobseekerDao.deleteById(id);
//      return new SuccessResult("Jobseeker has been deleted.");
//	}
//
//	@Override
//	public DataResult<Jobseeker> getById(int id) {
//		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.getOne(id));
//	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobseekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getJobseekerByNationalId(String nationalId) {
		return new SuccessDataResult<JobSeeker>(this.jobseekerDao.findJobseekerByNationalId(nationalId));
	}

}