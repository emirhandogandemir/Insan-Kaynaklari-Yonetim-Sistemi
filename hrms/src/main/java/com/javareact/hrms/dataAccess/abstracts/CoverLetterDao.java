package com.javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {
	CoverLetter getById(int id);
	
	List<CoverLetter> getAllByJobSeeker_id(int id);
}
