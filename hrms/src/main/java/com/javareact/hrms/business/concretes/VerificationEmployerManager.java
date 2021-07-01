package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.VerificationEmployerService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.VerificationEmployerDao;
import com.javareact.hrms.entities.concretes.VerificationEmployer;

@Service

public class VerificationEmployerManager implements VerificationEmployerService {

	private VerificationEmployerDao verificationEmployerDao;
	
	@Autowired
	public VerificationEmployerManager(VerificationEmployerDao verificationEmployerDao) {
		super();
		this.verificationEmployerDao = verificationEmployerDao;
	}

	@Override
	public Result add(VerificationEmployer verificationEmployer) {
		this.verificationEmployerDao.save(verificationEmployer);
		return new SuccessResult("verificationEmployer tablosuna eklendi");
	}

	@Override
	public Result delete(int id) {
		this.verificationEmployerDao.deleteById(id);
		return new SuccessResult("idye göre silindi tablodan");
	}

	@Override
	public DataResult<List<VerificationEmployer>> getAlll() {
		return new SuccessDataResult<List<VerificationEmployer>>(this.verificationEmployerDao.findAll());
	}

	@Override
	public DataResult<VerificationEmployer> getById(int id) {
		return new SuccessDataResult<VerificationEmployer>(this.verificationEmployerDao.getByUserId(id));
	}

}
