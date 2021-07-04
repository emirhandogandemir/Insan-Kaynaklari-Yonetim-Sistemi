package com.javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Integer> {

	Favorite getById(int id);
	
	List<Favorite> getByJobSeeker_Id(int jobSeekerId);
	
	List<Favorite> getByJobAdvert_Id(int jobAdvertId);
	
	Favorite getByJobAdvert_IdAndJobSeeker_Id(int jobAdvertId,int jobSeekerId);
	
}
