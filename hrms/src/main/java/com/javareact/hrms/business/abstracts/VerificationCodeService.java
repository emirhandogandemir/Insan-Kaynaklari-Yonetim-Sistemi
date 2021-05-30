package com.javareact.hrms.business.abstracts;

import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	Result add(VerificationCode code);
//	Result delete(VerificationCode code);
//	Result update(VerificationCode code);
//	
//    DataResult<VerificationCode> getById(int id);
//	DataResult<List<VerificationCode>> getAll();
	
}
