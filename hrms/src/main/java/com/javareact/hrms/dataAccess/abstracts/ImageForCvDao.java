package com.javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.ImageForCv;

public interface ImageForCvDao extends JpaRepository<ImageForCv, Integer> {
	
	ImageForCv getById(int id);
	
	ImageForCv getByJobSeeker_id(int id);
	
}
