package com.javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {
	
	Image getById(int id);
	
	Image getByJobSeeker_id(int id);
	
}
