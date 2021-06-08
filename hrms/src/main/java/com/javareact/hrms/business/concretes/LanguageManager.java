package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.LanguageService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.LanguageDao;
import com.javareact.hrms.entities.concretes.Language;
@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageForCvDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageForCvDao) {
		super();
		this.languageForCvDao = languageForCvDao;
	}

	@Override
	public Result add(Language languageForCvDao) {
		this.languageForCvDao.save(languageForCvDao);
		return new SuccessResult("jobSeekerLanguage added");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		return new SuccessDataResult<List<Language>>(this.languageForCvDao.findAll());
	}

	@Override
	public Result update(Language languageForCv) {
		this.languageForCvDao.save(languageForCv);
		return new SuccessResult("language has been updated");
	}

	@Override
	public Result delete(int id) {
		this.languageForCvDao.deleteById(id);
		return new SuccessResult("language has been deleted");
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(this.languageForCvDao.getById(id));
	}

	@Override
	public DataResult<List<Language>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<Language>>(this.languageForCvDao.getAllByJobSeeker_id(id));
	}

}
