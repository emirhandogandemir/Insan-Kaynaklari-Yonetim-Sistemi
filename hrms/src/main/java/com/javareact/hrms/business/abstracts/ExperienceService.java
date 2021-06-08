package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience experienceForCv);
	Result update(Experience experienceForCv);
	Result delete(int id);
	
	DataResult<Experience> getById(int id);
	DataResult<List<Experience>> getAll();
	DataResult<List<Experience>> getAllByJobSeekerIdOrderByLeaveDateDesc(int id);
	DataResult<List<Experience>> getAllByJobSeekerId(int id);
}
