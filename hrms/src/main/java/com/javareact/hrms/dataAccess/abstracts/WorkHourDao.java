package com.javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.WorkHour;

public interface WorkHourDao extends JpaRepository<WorkHour, Integer> {

}
