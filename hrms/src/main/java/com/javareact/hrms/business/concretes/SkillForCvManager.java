package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.SkillForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.SkillForCvDao;
import com.javareact.hrms.entities.concretes.SkillForCv;
@Service
public class SkillForCvManager implements SkillForCvService {

	private SkillForCvDao skillForCvDao;
	
	public SkillForCvManager(SkillForCvDao skillForCvDao) {
		super();
		this.skillForCvDao = skillForCvDao;
	}

	@Override
	public Result add(SkillForCv skillForCv) {
		this.skillForCvDao.save(skillForCv);
		return new SuccessResult("skill has been added");
	}

	@Override
	public Result delete(int id) {
		this.skillForCvDao.deleteById(id);
		return new SuccessResult("skill has been deleted");
	}
       
	@Override
	public Result update(SkillForCv skillForCv) {
		this.skillForCvDao.save(skillForCv);
		return new SuccessResult("skill has been updated");
	}

	@Override
	public DataResult<SkillForCv> getById(int id) {
		return new SuccessDataResult<SkillForCv>(this.skillForCvDao.getById(id));
	}

	@Override
	public DataResult<List<SkillForCv>> getAll() {
		return new SuccessDataResult<List<SkillForCv>>(this.skillForCvDao.findAll());
	}

	@Override
	public DataResult<List<SkillForCv>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<SkillForCv>>(this.skillForCvDao.getAllByJobSeeker_id(id));
	}

}
