package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.CityService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.ErrorResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.CityDao;
import com.javareact.hrms.entities.concretes.City;
@Service
public class CityManager implements CityService {

private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	
	@Override
	@CacheEvict(value="allCities" ,allEntries=true)
	public Result add(City city) {
		if(cityDao.findCityByName(city.getName())==null) {
			this.cityDao.save(city);
		    return new SuccessResult("City has been added.");
		}
		return new ErrorResult("City has not been added");
	}

	@Override
	public Result update(City city) {
		this.cityDao.save(city);
	    return new SuccessResult("City has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.cityDao.deleteById(id);
	    return new SuccessResult("City has been deleted.");
	}

	@Override
	public DataResult<City> getById(int id) {
		return new SuccessDataResult<City>(this.cityDao.getOne(id));
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

}
