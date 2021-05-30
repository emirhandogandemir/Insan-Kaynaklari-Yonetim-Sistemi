package com.javareact.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.VerificationCodeService;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.VerificationCodeDao;
import com.javareact.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	
private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(VerificationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Code has been saved.");
	}

//	@Override
//	public Result delete(VerificationCode code) {
//		this.verificationCodeDao.delete(code);
//		return new SuccessResult("Code has been deleted.");
//	}
//
//	@Override
//	public Result update(VerificationCode code) {
//		this.verificationCodeDao.save(code);
//		return new SuccessResult("Code has been updated.");
//	}
//
//	@Override
//	public DataResult<VerificationCode> getById(int id) {
//		return new SuccessDataResult<VerificationCode>(this.verificationCodeDao.getOne(id));
//	}
//
//	@Override
//	public DataResult<List<VerificationCode>> getAll() {
//		return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.findAll());
//	}
}
