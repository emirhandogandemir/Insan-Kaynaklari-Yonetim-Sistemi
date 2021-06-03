package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.ExperienceForCv;

public interface ExperienceForCvService {
	Result add(ExperienceForCv experienceForCv);
	Result update(ExperienceForCv experienceForCv);
	Result delete(int id);
	
	DataResult<ExperienceForCv> getById(int id);
	DataResult<List<ExperienceForCv>> getAll();
	DataResult<List<ExperienceForCv>> getAllByJobSeekerIdOrderByLeaveDateDesc(int id);
	DataResult<List<ExperienceForCv>> getAllByJobSeekerId(int id);
}
