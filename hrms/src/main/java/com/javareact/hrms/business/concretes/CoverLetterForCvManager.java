package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.CoverLetterForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.CoverLetterForCvDao;
import com.javareact.hrms.entities.concretes.CoverLetterForCv;

@Service
public class CoverLetterForCvManager implements CoverLetterForCvService {

	
	private CoverLetterForCvDao coverLetterForCvDao;
	
	@Autowired
	public CoverLetterForCvManager(CoverLetterForCvDao coverLetterForCvDao) {
		super();
		this.coverLetterForCvDao = coverLetterForCvDao;
	}





	@Override
	public Result add(CoverLetterForCv coverLetterForCv) {
		this.coverLetterForCvDao.save(coverLetterForCv);
		return new SuccessResult("coverLetterForCv added");
				
	}





	@Override
	public Result update(CoverLetterForCv coverLetterForCv) {
		this.coverLetterForCvDao.save(coverLetterForCv);
		return new SuccessResult("coverLetterForCv updated");
	}





	@Override
	public Result delete(int id) {
		this.coverLetterForCvDao.deleteById(id);
		return new SuccessResult("coverLetterForCv deleted");
	}





	@Override
	public DataResult<CoverLetterForCv> getById(int id) {
		return new SuccessDataResult<CoverLetterForCv>(this.coverLetterForCvDao.getById(id));
	}





	@Override
	public DataResult<List<CoverLetterForCv>> getAll() {
		return new SuccessDataResult<List<CoverLetterForCv>>(this.coverLetterForCvDao.findAll());
	}

}
