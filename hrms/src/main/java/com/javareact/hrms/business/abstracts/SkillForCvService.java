package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.SkillForCv;

public interface SkillForCvService {
Result add(SkillForCv skillForCv);
Result delete(int id);
Result update(SkillForCv skillForCv);

DataResult<SkillForCv> getById(int id);
DataResult<List<SkillForCv>> getAll();

DataResult<List<SkillForCv>> getAllByJobSeekerId(int id);
}
