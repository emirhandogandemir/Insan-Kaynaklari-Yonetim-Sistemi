package com.javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.VerificationEmployer;

public interface VerificationEmployerDao extends JpaRepository<VerificationEmployer, Integer> {
VerificationEmployer getByUserId(int userId);
}
