package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.LinkForCv;
import com.javareact.hrms.entities.concretes.SkillForCv;

public interface LinkForCvService {
	Result add(LinkForCv linkForCv);
	Result update(LinkForCv linkForCv);
	Result delete(int id);
	DataResult<List<LinkForCv>> getAll();
	DataResult<LinkForCv> getById(int id);
	DataResult<List<LinkForCv>> getAllByJobSeekerId(int id);
}
