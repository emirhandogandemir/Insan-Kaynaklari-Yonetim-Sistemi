package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.LinkForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.LinkForCvDao;
import com.javareact.hrms.entities.concretes.LinkForCv;
import com.javareact.hrms.entities.concretes.SkillForCv;
@Service
public class LinkForCvManager implements LinkForCvService {

	private LinkForCvDao jobSeekerLinkDao;
	
	@Autowired
	public LinkForCvManager(LinkForCvDao jobSeekerLinkDao) {
		super();
		this.jobSeekerLinkDao = jobSeekerLinkDao;
	}

	@Override
	public Result add(LinkForCv jobSeekerLink) {
		this.jobSeekerLinkDao.save(jobSeekerLink);
		return new SuccessResult("jobSeekerLink added");
	}

	@Override
	public DataResult<List<LinkForCv>> getAll() {
		return new SuccessDataResult<List<LinkForCv>>(this.jobSeekerLinkDao.findAll());
	}

	@Override
	public Result update(LinkForCv linkForCv) {
		this.jobSeekerLinkDao.save(linkForCv);
		
		return new SuccessResult("Link has been updated");
	}

	@Override
	public Result delete(int id) {
		this.jobSeekerLinkDao.deleteById(id);
		return new SuccessResult("\"Link has been deleted");
	}

	@Override
	public DataResult<LinkForCv> getById(int id) {
		return new SuccessDataResult<LinkForCv>(this.jobSeekerLinkDao.getById(id));
	}

	@Override
	public DataResult<List<LinkForCv>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<LinkForCv>>(this.jobSeekerLinkDao.getAllByJobSeeker_id(id));
	}

}
