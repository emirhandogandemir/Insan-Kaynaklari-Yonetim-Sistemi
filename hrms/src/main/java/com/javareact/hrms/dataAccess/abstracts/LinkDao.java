package com.javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.Link;


public interface LinkDao extends JpaRepository<Link, Integer> {
	Link getById(int id);
	
	List<Link> getAllByJobSeeker_id(int id);
}
