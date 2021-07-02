package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.VerificationEmployer;

public interface VerificationEmployerService {
	Result add(VerificationEmployer verificationEmployer);

	Result delete(int id);

	DataResult<List<VerificationEmployer>> getAlll();
	
	DataResult<VerificationEmployer> getById(int id);
	
	DataResult<List<VerificationEmployer>> getAllByVerifyFalse();
}
