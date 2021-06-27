package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.CoverLetterService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.CoverLetterDao;
import com.javareact.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService {

	private CoverLetterDao coverLetterForCvDao;

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterForCvDao) {
		super();
		this.coverLetterForCvDao = coverLetterForCvDao;
	}

	@Override
	public Result add(CoverLetter coverLetterForCv) {
		this.coverLetterForCvDao.save(coverLetterForCv);
		return new SuccessResult("coverLetterForCv added");

	}

	@Override
	public Result update(CoverLetter coverLetterForCv) {
		this.coverLetterForCvDao.save(coverLetterForCv);
		return new SuccessResult("coverLetterForCv updated");
	}

	@Override
	public Result delete(int id) {
		this.coverLetterForCvDao.deleteById(id);
		return new SuccessResult("coverLetterForCv deleted");
	}

	@Override
	public DataResult<CoverLetter> getById(int id) {
		return new SuccessDataResult<CoverLetter>(this.coverLetterForCvDao.getById(id));
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterForCvDao.findAll());
	}

	@Override
	public DataResult<List<CoverLetter>> getAllByJobSeekerId(int id) {

		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterForCvDao.getAllByJobSeeker_id(id));
	}

}
