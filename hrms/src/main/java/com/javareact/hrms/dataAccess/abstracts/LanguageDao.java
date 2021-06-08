package com.javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {

	Language getById(int id);
	List<Language> getAllByJobSeeker_id(int id);
	
}
