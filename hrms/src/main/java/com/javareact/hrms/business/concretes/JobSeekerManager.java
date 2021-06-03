package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.EducationForCvService;
import com.javareact.hrms.business.abstracts.ExperienceForCvService;
import com.javareact.hrms.business.abstracts.ImageForCvService;
import com.javareact.hrms.business.abstracts.JobSeekerService;
import com.javareact.hrms.business.abstracts.LanguageForCvService;
import com.javareact.hrms.business.abstracts.LinkForCvService;
import com.javareact.hrms.business.abstracts.SkillForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.JobSeekerDao;
import com.javareact.hrms.entities.concretes.JobSeeker;
import com.javareact.hrms.entities.dtos.JobSeekerCvDto;
@Service
public class JobSeekerManager implements JobSeekerService {

	private ExperienceForCvService experienceForCvService;
	private LanguageForCvService languageForCvService;
	private ImageForCvService imageForCvService;
	private LinkForCvService linkForCvService;
	private SkillForCvService skillForCvService;
	private EducationForCvService educationForCvService;
	private JobSeekerDao jobseekerDao;

@Autowired
	public JobSeekerManager(ExperienceForCvService experienceForCvService, LanguageForCvService languageForCvService,
			ImageForCvService imageForCvService, LinkForCvService linkForCvService, SkillForCvService skillForCvService,
			EducationForCvService educationForCvService, JobSeekerDao jobseekerDao) {
		super();
		this.experienceForCvService = experienceForCvService;
		this.languageForCvService = languageForCvService;
		this.imageForCvService = imageForCvService;
		this.linkForCvService = linkForCvService;
		this.skillForCvService = skillForCvService;
		this.educationForCvService = educationForCvService;
		this.jobseekerDao = jobseekerDao;
	}

	@Override
	public Result add(JobSeeker jobseeker) {
		this.jobseekerDao.save(jobseeker);

		return new SuccessResult("Jobseeker has been added.");
	}

	@Override
	public Result update(JobSeeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("Jobseeker has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobseekerDao.deleteById(id);
		return new SuccessResult("Jobseeker has been deleted.");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobseekerDao.getOne(id));
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobseekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getJobseekerByNationalId(String nationalId) {
		return new SuccessDataResult<JobSeeker>(this.jobseekerDao.findJobseekerByNationalId(nationalId));
	}

	@Override
	public DataResult<JobSeekerCvDto> getJobseekerCVById(int id) {
		JobSeekerCvDto cv= new JobSeekerCvDto();
		cv.experiences=this.experienceForCvService.getAllByJobSeekerId(id).getData();
		cv.languages=this.languageForCvService.getAllByJobSeekerId(id).getData();
		cv.image=this.imageForCvService.getByJobSeekerId(id).getData();
		cv.links =this.linkForCvService.getAllByJobSeekerId(id).getData();
		cv.skills=this.skillForCvService.getAllByJobSeekerId(id).getData();
		cv.educations=this.educationForCvService.getAllByJobSeekerId(id).getData();
		return new SuccessDataResult<JobSeekerCvDto>(cv);
	}

}