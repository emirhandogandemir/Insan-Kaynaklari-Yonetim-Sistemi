package com.javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.JobAdvertConfirmation;

public interface JobAdvertConfirmationDao extends JpaRepository<JobAdvertConfirmation, Integer> {

}
