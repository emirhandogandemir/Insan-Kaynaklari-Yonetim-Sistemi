package com.javareact.hrms.business.abstracts;

import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Employer;
import com.javareact.hrms.entities.concretes.JobSeeker;

public interface AuthService {
	Result registerEmployer(Employer employer, String confirmPassword);
	Result registerJobseeker(JobSeeker jobseeker, String confirmPassword);
}
