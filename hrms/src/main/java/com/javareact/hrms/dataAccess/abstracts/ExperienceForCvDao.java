package com.javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.ExperienceForCv;

public interface ExperienceForCvDao extends JpaRepository<ExperienceForCv, Integer> {
ExperienceForCv getById(int id);
List<ExperienceForCv>  getAllByJobSeeker_idOrderByLeaveDateDesc(int id);
List<ExperienceForCv> getAllByJobSeeker_id(int id);
}
