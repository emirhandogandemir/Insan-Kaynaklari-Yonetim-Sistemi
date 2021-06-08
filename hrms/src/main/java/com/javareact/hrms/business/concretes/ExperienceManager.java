package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.ExperienceService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.ExperienceDao;
import com.javareact.hrms.entities.concretes.Experience;
@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceForCvDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceForCvDao) {
		super();
		this.experienceForCvDao = experienceForCvDao;
	}

	@Override
	public Result add(Experience jobSeekerExperience) {
		this.experienceForCvDao.save(jobSeekerExperience);
		return new SuccessResult("jobSeekerExperience added ");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		
		return new SuccessDataResult<List<Experience>>(this.experienceForCvDao.findAll());
	}

	@Override
	public Result update(Experience experienceForCv) {
		this.experienceForCvDao.save(experienceForCv);
		return new SuccessResult("experience has been updated");
	}

	@Override
	public Result delete(int id) {
		this.experienceForCvDao.deleteById(id);
		return new SuccessResult("experience has been deleted");
	}

	@Override
	public DataResult<Experience> getById(int id) {
		return new SuccessDataResult<Experience>(this.experienceForCvDao.getById(id));
	}

	@Override
	public DataResult<List<Experience>> getAllByJobSeekerIdOrderByLeaveDateDesc(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceForCvDao.getAllByJobSeeker_idOrderByLeaveDateDesc(id));
	}

	@Override
	public DataResult<List<Experience>> getAllByJobSeekerId(int id) {
	return new SuccessDataResult<List<Experience>>(this.experienceForCvDao.getAllByJobSeeker_id(id));
	}

}
