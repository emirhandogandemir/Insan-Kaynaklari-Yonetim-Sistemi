package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Link;
import com.javareact.hrms.entities.concretes.Skill;

public interface LinkService {
	Result add(Link linkForCv);
	Result update(Link linkForCv);
	Result delete(int id);
	DataResult<List<Link>> getAll();
	DataResult<Link> getById(int id);
	DataResult<List<Link>> getAllByJobSeekerId(int id);
}
