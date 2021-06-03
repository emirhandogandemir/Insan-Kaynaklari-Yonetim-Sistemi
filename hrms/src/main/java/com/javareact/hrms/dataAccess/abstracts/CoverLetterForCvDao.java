package com.javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.CoverLetterForCv;

public interface CoverLetterForCvDao extends JpaRepository<CoverLetterForCv, Integer> {
	CoverLetterForCv getById(int id);
}
