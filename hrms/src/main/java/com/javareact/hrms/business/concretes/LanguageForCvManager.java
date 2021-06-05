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

	private LanguageForCvDao languageForCvDao;
	
	@Autowired
	public LanguageForCvManager(LanguageForCvDao languageForCvDao) {
		super();
		this.languageForCvDao = languageForCvDao;
	}

	@Override
	public Result add(LanguageForCv languageForCvDao) {
		this.languageForCvDao.save(languageForCvDao);
		return new SuccessResult("jobSeekerLanguage added");
	}

	@Override
	public DataResult<List<LanguageForCv>> getAll() {
		
		return new SuccessDataResult<List<LanguageForCv>>(this.languageForCvDao.findAll());
	}

	@Override
	public Result update(LanguageForCv languageForCv) {
		this.languageForCvDao.save(languageForCv);
		return new SuccessResult("language has been updated");
	}

	@Override
	public Result delete(int id) {
		this.languageForCvDao.deleteById(id);
		return new SuccessResult("language has been deleted");
	}

	@Override
	public DataResult<LanguageForCv> getById(int id) {
		return new SuccessDataResult<LanguageForCv>(this.languageForCvDao.getById(id));
	}

	@Override
	public DataResult<List<LanguageForCv>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<LanguageForCv>>(this.languageForCvDao.getAllByJobSeeker_id(id));
	}

}
