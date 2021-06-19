package com.javareact.hrms.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.AuthService;
import com.javareact.hrms.business.abstracts.EmployerService;
import com.javareact.hrms.business.abstracts.JobSeekerService;
import com.javareact.hrms.business.abstracts.UserService;
import com.javareact.hrms.business.abstracts.VerificationCodeService;
import com.javareact.hrms.core.emailSender.spring.EmailSenderService;
import com.javareact.hrms.core.utilities.adapters.MernisService;
import com.javareact.hrms.core.utilities.results.ErrorResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.core.utilities.verification.VerificationService;
import com.javareact.hrms.entities.concretes.Employer;
import com.javareact.hrms.entities.concretes.JobSeeker;
import com.javareact.hrms.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerService employerService;
	private JobSeekerService jobseekerService;
	private VerificationService verificationService;
	private MernisService mernisService;
	private VerificationCodeService verificationCodeService;
	private EmailSenderService emailSenderService;

	
	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, JobSeekerService jobseekerService,
			VerificationService verificationService,  MernisService mernisService,
			VerificationCodeService verificationCodeService,EmailSenderService emailSenderService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.jobseekerService = jobseekerService;
		this.verificationService = verificationService;
		this.mernisService = mernisService;
		this.verificationCodeService = verificationCodeService;
		this.emailSenderService=emailSenderService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!checkIfNullInfoForEmployer(employer)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebsite())) {

			return new ErrorResult("Invalid email address.");
		}

		if (!checkIfEmailExists(employer.getEmail())) {

			return new ErrorResult(employer.getEmail() + " already exists.");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {

			return new ErrorResult("Passwords do not match.");
		}

		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, employer.getId(), employer.getEmail());
		emailSenderService.sendSimpleEmail("emirhandgndmr51@gmail.com","Doğrulama kodunuz : "+code, "Hrms Project Verification");
		return new SuccessResult("Registration has been successfully completed");

	}

	@Override
	public Result registerJobseeker(JobSeeker jobseeker, String confirmPassword) {

		if (checkIfRealPerson(jobseeker.getNationalId(), jobseeker.getFirstName(),
				jobseeker.getLastName(), jobseeker.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("TCKN could not be verified.");
		}

		if (!checkIfNullInfoForJobseeker(jobseeker, confirmPassword)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfExistsTcNo(jobseeker.getNationalId())) {

			return new ErrorResult(jobseeker.getNationalId() + " already exists.");
		}

		if (!checkIfEmailExists(jobseeker.getEmail())) {

			return new ErrorResult(jobseeker.getEmail() + " already exists.");
		}

		
		jobseekerService.add(jobseeker);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, jobseeker.getId(), jobseeker.getEmail());
		emailSenderService.sendSimpleEmail("emirhandgndmr@mail.com.tr","Doğrulama Kodunuz : "+code, "Hrms Project Verification");
		return new SuccessResult("Registration has been successfully completed");
	}

	// Validation for employer register ---START---

	private boolean checkIfNullInfoForEmployer(Employer employer) {
		// Bütün alanların boş olup olmadığını kontrol ediyor

		if (employer.getCompanyName() != null && employer.getWebsite() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	// Validation for employer register ---END---

	// Validation for jobseeker register ---START---
	
	private boolean checkIfNullInfoForJobseeker(JobSeeker jobseeker, String confirmPassword) {
// iş arayanların fieldlarını boş olup olmamasına göre kontrol ediyor
		if (jobseeker.getFirstName() != null && jobseeker.getLastName() != null && jobseeker.getNationalId() != null
				&& jobseeker.getDateOfBirth() != null && jobseeker.getPassword() != null && jobseeker.getEmail() != null
				&& confirmPassword != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsTcNo(String nationalId) {
// NationalId yi kontrol ediyor varsa eklemiycek 
		if (this.jobseekerService.getJobseekerByNationalId(nationalId).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfRealPerson(String nationalId, String firstName, String lastName, int yearOfBirth) {

		if (mernisService.validateByMernis(nationalId, firstName, lastName, yearOfBirth)) {
			return true;
		}
		return false;
	}

	// Validation for jobseeker register ---END---

	// Common Validation

	private boolean checkIfEmailExists(String email) {
// emaili kontrol ediyor eğer email varsa ekleme olmıycak
		if (this.userService.getUserByEmail(email).getData() == null) {

			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {
// password ve doğrulama passwordunun aynı olup olmadığını kontrol ediyor
		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}
	
	private void verificationCodeRecord(String code, int id, String email) {
		
		VerificationCode verificationCode = new VerificationCode(id, code, false, LocalDate.now());
		this.verificationCodeService.add(verificationCode);
		System.out.println("Verification code has been sent to " + email );
	
	}
}
