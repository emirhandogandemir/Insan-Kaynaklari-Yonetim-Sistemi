package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.EducationForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.EducationForCvDao;
import com.javareact.hrms.entities.concretes.EducationForCv;
@Service
public class EducationForCvManager implements EducationForCvService {

	private EducationForCvDao educationForCvDao;
	
	@Autowired
	public EducationForCvManager(EducationForCvDao educationForCvDao) {
		super();
		this.educationForCvDao = educationForCvDao;
	}

	@Override
	public Result add(EducationForCv jobSeekerEducation) {
		
		this.educationForCvDao.save(jobSeekerEducation);
		return new SuccessResult("education added");
	}

	@Override
	public DataResult<List<EducationForCv>> getAll() {
		return new SuccessDataResult<List<EducationForCv>>(this.educationForCvDao.findAll());
	}

	@Override
	public Result update(EducationForCv educationForCv) {
	this.educationForCvDao.save(educationForCv);
	return new SuccessResult("education has been updated");
	}

	@Override
	public Result delete(int id) {
		this.educationForCvDao.deleteById(id);
		return new SuccessResult("education has been deleted");
	}

	@Override
	public DataResult<EducationForCv> getById(int id) {
		return new SuccessDataResult<EducationForCv>(this.educationForCvDao.getById(id));
	}

	@Override
	public DataResult<List<EducationForCv>> getByJobSeekerIdOrderByGraduationYearDesc(int id) {
	return new SuccessDataResult<List<EducationForCv>> (this.educationForCvDao.getAllByJobSeeker_idOrderByGraduationYearDesc(id));
	}

	@Override
	public DataResult<List<EducationForCv>> getAllByJobSeekerId(int id) {
	
		return new SuccessDataResult<List<EducationForCv>>(this.educationForCvDao.getAllByJobSeeker_id(id));
	}

}
