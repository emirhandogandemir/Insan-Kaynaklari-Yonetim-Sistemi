package com.javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
	City getById(int id);

	City findCityByName(String name);
}
