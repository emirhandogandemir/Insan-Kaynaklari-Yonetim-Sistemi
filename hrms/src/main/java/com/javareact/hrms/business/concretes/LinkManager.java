package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.LinkService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.LinkDao;
import com.javareact.hrms.entities.concretes.Link;
import com.javareact.hrms.entities.concretes.Skill;
@Service
public class LinkManager implements LinkService {

	private LinkDao jobSeekerLinkDao;
	
	@Autowired
	public LinkManager(LinkDao jobSeekerLinkDao) {
		super();
		this.jobSeekerLinkDao = jobSeekerLinkDao;
	}

	@Override
	public Result add(Link jobSeekerLink) {
		this.jobSeekerLinkDao.save(jobSeekerLink);
		return new SuccessResult("jobSeekerLink added");
	}

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(this.jobSeekerLinkDao.findAll());
	}

	@Override
	public Result update(Link linkForCv) {
		this.jobSeekerLinkDao.save(linkForCv);
		
		return new SuccessResult("Link has been updated");
	}

	@Override
	public Result delete(int id) {
		this.jobSeekerLinkDao.deleteById(id);
		return new SuccessResult("\"Link has been deleted");
	}

	@Override
	public DataResult<Link> getById(int id) {
		return new SuccessDataResult<Link>(this.jobSeekerLinkDao.getById(id));
	}

	@Override
	public DataResult<List<Link>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<Link>>(this.jobSeekerLinkDao.getAllByJobSeeker_id(id));
	}

}
