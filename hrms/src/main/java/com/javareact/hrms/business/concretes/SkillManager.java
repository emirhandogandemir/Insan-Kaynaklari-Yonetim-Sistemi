package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.SkillService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.SkillDao;
import com.javareact.hrms.entities.concretes.Skill;
@Service
public class SkillManager implements SkillService {

	private SkillDao skillForCvDao;
	
	public SkillManager(SkillDao skillForCvDao) {
		super();
		this.skillForCvDao = skillForCvDao;
	}

	@Override
	public Result add(Skill skillForCv) {
		this.skillForCvDao.save(skillForCv);
		return new SuccessResult("skill has been added");
	}

	@Override
	public Result delete(int id) {
		this.skillForCvDao.deleteById(id);
		return new SuccessResult("skill has been deleted");
	}
       
	@Override
	public Result update(Skill skillForCv) {
		this.skillForCvDao.save(skillForCv);
		return new SuccessResult("skill has been updated");
	}

	@Override
	public DataResult<Skill> getById(int id) {
		return new SuccessDataResult<Skill>(this.skillForCvDao.getById(id));
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillForCvDao.findAll());
	}

	@Override
	public DataResult<List<Skill>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<Skill>>(this.skillForCvDao.getAllByJobSeeker_id(id));
	}

}
