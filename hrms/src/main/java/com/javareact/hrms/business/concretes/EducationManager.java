package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.EducationService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.EducationDao;
import com.javareact.hrms.entities.concretes.Education;
@Service
public class EducationManager implements EducationService {

	private EducationDao educationForCvDao;
	
	@Autowired
	public EducationManager(EducationDao educationForCvDao) {
		super();
		this.educationForCvDao = educationForCvDao;
	}

	@Override
	public Result add(Education jobSeekerEducation) {
		
		this.educationForCvDao.save(jobSeekerEducation);
		return new SuccessResult("education added");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationForCvDao.findAll());
	}

	@Override
	public Result update(Education educationForCv) {
	this.educationForCvDao.save(educationForCv);
	return new SuccessResult("education has been updated");
	}

	@Override
	public Result delete(int id) {
		this.educationForCvDao.deleteById(id);
		return new SuccessResult("education has been deleted");
	}

	@Override
	public DataResult<Education> getById(int id) {
		return new SuccessDataResult<Education>(this.educationForCvDao.getById(id));
	}

	@Override
	public DataResult<List<Education>> getByJobSeekerIdOrderByGraduationYearDesc(int id) {
	return new SuccessDataResult<List<Education>> (this.educationForCvDao.getAllByJobSeeker_idOrderByGraduationYearDesc(id));
	}

	@Override
	public DataResult<List<Education>> getAllByJobSeekerId(int id) {
	
		return new SuccessDataResult<List<Education>>(this.educationForCvDao.getAllByJobSeeker_id(id));
	}

}
