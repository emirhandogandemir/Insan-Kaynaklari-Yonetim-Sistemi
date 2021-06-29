package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import com.javareact.hrms.business.abstracts.EmployerService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.EmployerDao;
import com.javareact.hrms.entities.concretes.Employer;



@Service

public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	@CacheEvict(value="allEmployers",allEntries=true)
	public Result add(Employer employer) {
		this.employerDao.save(employer);
        return new SuccessResult("Employer has been added.");
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
      return new SuccessResult("Employer has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
	    return new SuccessResult("Employer has been deleted.");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getOne(id));
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<List<Employer>> getAllByVerify() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getAllByVerify());
	}

	@Override
	public Result changeIsVerifiedByEmployee(int employerId) {
		Employer employer = this.employerDao.getById(employerId);
		employer.setVerified(!employer.isVerified());
		this.employerDao.save(employer);
		return new SuccessResult("Şirketin Doğrulanma durumu değiştirildi");
	}

	
	
}
