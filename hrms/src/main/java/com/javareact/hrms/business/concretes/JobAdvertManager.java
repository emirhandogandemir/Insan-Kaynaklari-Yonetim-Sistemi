package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.JobAdvertService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.ErrorResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.CityDao;
import com.javareact.hrms.dataAccess.abstracts.EmployerDao;
import com.javareact.hrms.dataAccess.abstracts.JobAdvertConfirmationDao;
import com.javareact.hrms.dataAccess.abstracts.JobAdvertDao;
import com.javareact.hrms.dataAccess.abstracts.JobPositionDao;
import com.javareact.hrms.dataAccess.abstracts.WorkHourDao;
import com.javareact.hrms.dataAccess.abstracts.WorkTypeDao;
import com.javareact.hrms.entities.concretes.JobAdvert;
import com.javareact.hrms.entities.concretes.JobAdvertConfirmation;
import com.javareact.hrms.entities.dtos.JobAdvertDto;
@Service
public class JobAdvertManager implements JobAdvertService {

	
	
	private JobAdvertDao jobAdvertDao;
	private CityDao cityDao;
	private EmployerDao employerDao;
	private JobPositionDao jobPositionDao;
	private WorkTypeDao workTypeDao;
	private WorkHourDao workHourDao;
	private JobAdvertConfirmationDao jobAdvertConfirmationDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, CityDao cityDao, EmployerDao employerDao,
			JobPositionDao jobPositionDao, WorkTypeDao workTypeDao, WorkHourDao workHourDao,
			JobAdvertConfirmationDao jobAdvertConfirmationDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
		this.jobPositionDao = jobPositionDao;
		this.workTypeDao = workTypeDao;
		this.workHourDao = workHourDao;
		this.jobAdvertConfirmationDao = jobAdvertConfirmationDao;
	}



	@Override
	//@CacheEvict(value="allJobAdverts" ,allEntries=true)
	public Result add(JobAdvertDto jobAdvertDto) {
		
		// Dao , business, frontend = ?
	
		JobAdvert jobAdvert = new JobAdvert();
		jobAdvert.setCity(this.cityDao.getById(jobAdvertDto.getCityId()));
		jobAdvert.setJobPosition(this.jobPositionDao.getById(jobAdvertDto.getJobPositionId()));
		jobAdvert.setWorkHour(this.workHourDao.getById(jobAdvertDto.getWorkHourId()));
		jobAdvert.setWorkType(this.workTypeDao.getById(jobAdvertDto.getWorkTypeId()));
		jobAdvert.setDescription(jobAdvertDto.getDescription());
		jobAdvert.setSalaryMax(jobAdvertDto.getMaxSalary());
		jobAdvert.setSalaryMin(jobAdvertDto.getMinSalary());
		jobAdvert.setOpenPositionCount(jobAdvertDto.getOpenPositionCount());
		jobAdvert.setEmployer(this.employerDao.getById(jobAdvertDto.getEmployerId()));
		jobAdvert.setDeadline(jobAdvertDto.getDeadLine());
	
		
		this.jobAdvertDao.save(jobAdvert);
		
		//JobAdvertConfirmation jobAdvertConfirmation = new JobAdvertConfirmation();
		return new SuccessResult("başarı ile eklendi");
		
	}

	
	
	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Job advert has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("Job advert has been deleted.");
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getOne(id));
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}


	@Override
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllOpenJobAdvertList());
	}

	@Override
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedAt() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByOrderByPublishedAtDesc());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllOpenJobAdvertByEmployer(id));
	}

	private boolean CheckIfNullField(JobAdvert jobAdvert) {
		if (jobAdvert.getJobPosition().getId() != 0 && jobAdvert.getDescription() != null && jobAdvert.getCity().getId() != 0
				&& jobAdvert.getOpenPositionCount() != 0) {
			return true;
		}
		return false;
	}



	@Override
	public DataResult<List<JobAdvert>> getAllByIsActiveByEmployee() {
	// BURASI AÇIK İŞ İLANLARI VE DOĞRULANMIŞ İŞ İLANLARININ GÖZÜKTÜĞÜ KISIM
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllByIsActiveByEmployee()); 
	}



	@Override
	public DataResult<List<JobAdvert>> getAllByIsActiveByEmployee_False() {
		// Açık olan iş ilanlarını admin görecek sadece kendi sisteminden onaylamak için
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllByIsActiveByEmployee_False()) ;
	}



	@Override
	public Result changeIsActiveByEmployee(int jobAdvertId) {
		// sadece trueya çekmek için 
	JobAdvert jobAdvertIsActiveEmployee= this.jobAdvertDao.getById(jobAdvertId);
	jobAdvertIsActiveEmployee.setActive(!jobAdvertIsActiveEmployee.isActive());
	this.jobAdvertDao.save(jobAdvertIsActiveEmployee);
	return new SuccessResult("İş ilanının admin tarafından aktifliği değiştirildi");
	}



	@Override
	public Result changeIsOpenByEmployer(int jobAdvertId) {
		// İş verenin aktiflik değiştireceği
		JobAdvert jobAdvertToChangeIsOpen =this.jobAdvertDao.getById(jobAdvertId);
		jobAdvertToChangeIsOpen.setOpen(!jobAdvertToChangeIsOpen.isOpen());
		this.jobAdvertDao.save(jobAdvertToChangeIsOpen);
		return new SuccessResult("İş ilanının iş veren tarafından tarafından aktifliği değiştirildi");
	}



	@Override
	public DataResult<List<JobAdvert>> getAllByEmployerId(int employerId) {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllByEmployerId(employerId),"Employer Idye göre getirildi");
	}

}
