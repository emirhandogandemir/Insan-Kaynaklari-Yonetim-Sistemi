package com.javareact.hrms.business.abstracts;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.*;
import java.util.List;
public interface CityService {
	Result add(City city);
	Result update(City city);
	Result delete(int id);
	DataResult<City> getById(int id);
	
	DataResult<List<City>> getAll();
}
