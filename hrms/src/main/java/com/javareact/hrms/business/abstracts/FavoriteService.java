package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Experience;
import com.javareact.hrms.entities.concretes.Favorite;

public interface FavoriteService {

	Result add(Favorite favorite);
	Result update(Favorite favorite);
	
	Result delete(int id);
	
	DataResult<Favorite> getById(int id);
	DataResult<List<Favorite>> getAll();
	
	DataResult<List<Favorite>> getByJobSeekerId(int jobSeekerId);
	DataResult<List<Favorite>> getByJobAdvertId(int jobAdvertId);
}
