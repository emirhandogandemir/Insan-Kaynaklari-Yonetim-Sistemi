package com.javareact.hrms.dataAccess.abstracts;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode,Integer>{
	// Optional<VerificationCode> findByUserUuid(UUID uuid);
	
	VerificationCode getById(int id);
}
