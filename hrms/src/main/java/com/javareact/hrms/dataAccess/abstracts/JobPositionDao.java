package com.javareact.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;


import com.javareact.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{
	JobPosition findByJobTitle(String title); 

	JobPosition getById(int id);
}
