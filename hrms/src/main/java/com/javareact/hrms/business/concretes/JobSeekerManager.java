package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.EducationService;
import com.javareact.hrms.business.abstracts.ExperienceService;
import com.javareact.hrms.business.abstracts.ImageService;
import com.javareact.hrms.business.abstracts.JobSeekerService;
import com.javareact.hrms.business.abstracts.LanguageService;
import com.javareact.hrms.business.abstracts.LinkService;
import com.javareact.hrms.business.abstracts.SkillService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.JobSeekerDao;
import com.javareact.hrms.entities.concretes.JobSeeker;
import com.javareact.hrms.entities.dtos.JobSeekerCvDto;
@Service
public class JobSeekerManager implements JobSeekerService {

	private ExperienceService experienceForCvService;
	private LanguageService languageForCvService;
	private ImageService imageForCvService;
	private LinkService linkForCvService;
	private SkillService skillForCvService;
	private EducationService educationForCvService;
	private JobSeekerDao jobseekerDao;

@Autowired
	public JobSeekerManager(ExperienceService experienceForCvService, LanguageService languageForCvService,
			ImageService imageForCvService, LinkService linkForCvService, SkillService skillForCvService,
			EducationService educationForCvService, JobSeekerDao jobseekerDao) {
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
	@CacheEvict(value="allJobSeekers",allEntries=true)
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