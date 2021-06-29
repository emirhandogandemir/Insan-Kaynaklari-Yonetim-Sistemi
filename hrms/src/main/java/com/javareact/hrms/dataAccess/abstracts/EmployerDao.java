package com.javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javareact.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer getById(int id);
	
	//Employer getByIdVerify(int id);
	
	@Query("From Employer where is_verified=false")
	List<Employer> getAllByVerify();
	
}
