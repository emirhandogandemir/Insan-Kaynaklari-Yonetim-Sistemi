package com.javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {
	Skill getById(int id);
	List<Skill> getAllByJobSeeker_id(int id);
}
