package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.ExperienceForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.ExperienceForCvDao;
import com.javareact.hrms.entities.concretes.ExperienceForCv;
@Service
public class ExperienceForCvManager implements ExperienceForCvService {

	private ExperienceForCvDao experienceForCvDao;
	
	@Autowired
	public ExperienceForCvManager(ExperienceForCvDao experienceForCvDao) {
		super();
		this.experienceForCvDao = experienceForCvDao;
	}

	@Override
	public Result add(ExperienceForCv jobSeekerExperience) {
		this.experienceForCvDao.save(jobSeekerExperience);
		return new SuccessResult("jobSeekerExperience added ");
	}

	@Override
	public DataResult<List<ExperienceForCv>> getAll() {
		
		return new SuccessDataResult<List<ExperienceForCv>>(this.experienceForCvDao.findAll());
	}

	@Override
	public Result update(ExperienceForCv experienceForCv) {
		this.experienceForCvDao.save(experienceForCv);
		return new SuccessResult("experience has been updated");
	}

	@Override
	public Result delete(int id) {
		this.experienceForCvDao.deleteById(id);
		return new SuccessResult("experience has been deleted");
	}

	@Override
	public DataResult<ExperienceForCv> getById(int id) {
		return new SuccessDataResult<ExperienceForCv>(this.experienceForCvDao.getById(id));
	}

	@Override
	public DataResult<List<ExperienceForCv>> getAllByJobSeekerIdOrderByLeaveDateDesc(int id) {
		return new SuccessDataResult<List<ExperienceForCv>>(this.experienceForCvDao.getAllByJobSeeker_idOrderByLeaveDateDesc(id));
	}

	@Override
	public DataResult<List<ExperienceForCv>> getAllByJobSeekerId(int id) {
	return new SuccessDataResult<List<ExperienceForCv>>(this.experienceForCvDao.getAllByJobSeeker_id(id));
	}

}
