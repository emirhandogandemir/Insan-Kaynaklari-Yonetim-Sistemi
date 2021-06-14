package com.javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.WorkHour;
import com.javareact.hrms.entities.concretes.WorkType;

public interface WorkTypeDao extends JpaRepository<WorkType, Integer> {
	
WorkHour getById(int id);

WorkHour getByWorkType(String workType);



}
