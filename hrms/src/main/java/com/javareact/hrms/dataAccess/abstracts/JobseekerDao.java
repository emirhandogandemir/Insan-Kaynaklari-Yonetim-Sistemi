package com.javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	JobSeeker findJobseekerByNationalId(String nationalId);
	//veritabanında tc no arıyor bu

	
}
