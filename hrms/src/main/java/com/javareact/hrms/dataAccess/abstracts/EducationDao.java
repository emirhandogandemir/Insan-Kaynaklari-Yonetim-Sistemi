package com.javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
Education getById(int id);

List<Education> getAllByJobSeeker_idOrderByGraduationYearDesc(int id);

List<Education> getAllByJobSeeker_id(int id);
}
