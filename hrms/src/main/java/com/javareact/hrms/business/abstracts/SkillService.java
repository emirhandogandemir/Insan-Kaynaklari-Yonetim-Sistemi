package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Skill;

public interface SkillService {
Result add(Skill skillForCv);
Result delete(int id);
Result update(Skill skillForCv);

DataResult<Skill> getById(int id);
DataResult<List<Skill>> getAll();

DataResult<List<Skill>> getAllByJobSeekerId(int id);
}
