package com.javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.SkillForCv;

public interface SkillForCvDao extends JpaRepository<SkillForCv, Integer> {
	SkillForCv getById(int id);
	List<SkillForCv> getAllByJobSeeker_id(int id);
}
