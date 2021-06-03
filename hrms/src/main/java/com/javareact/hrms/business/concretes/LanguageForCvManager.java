package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.LanguageForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.LanguageForCvDao;
import com.javareact.hrms.entities.concretes.LanguageForCv;
@Service
public class LanguageForCvManager implements LanguageForCvService {

	private LanguageForCvDao jobSeekerLanguageDao;
	
	@Autowired
	public LanguageForCvManager(LanguageForCvDao jobSeekerLanguageDao) {
		super();
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
	}

	@Override
	public Result add(LanguageForCv jobSeekerLanguage) {
		this.jobSeekerLanguageDao.save(jobSeekerLanguage);
		return new SuccessResult("jobSeekerLanguage added");
	}

	@Override
	public DataResult<List<LanguageForCv>> getAll() {
		
		return new SuccessDataResult<List<LanguageForCv>>(this.jobSeekerLanguageDao.findAll());
	}

	@Override
	public Result update(LanguageForCv languageForCv) {
		this.jobSeekerLanguageDao.save(languageForCv);
		return new SuccessResult("language has been deleted");
	}

	@Override
	public Result delete(int id) {
		this.jobSeekerLanguageDao.deleteById(id);
		return new SuccessResult("language has been deleted");
	}

	@Override
	public DataResult<LanguageForCv> getById(int id) {
		return new SuccessDataResult<LanguageForCv>(this.jobSeekerLanguageDao.getById(id));
	}

	@Override
	public DataResult<List<LanguageForCv>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<LanguageForCv>>(this.jobSeekerLanguageDao.getAllByJobSeeker_id(id));
	}

}
