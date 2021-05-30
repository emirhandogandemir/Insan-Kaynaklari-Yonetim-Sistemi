package com.javareact.hrms.core.utilities.adapters;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.entities.concretes.JobSeeker;
import com.javareact.hrms.fakeMernisService.FakeMernisManager;
@Service
public class FakeMernisManagerAdapter implements MernisService{

	@Autowired
	FakeMernisManager fakeMernisManager;
	
	


	@Override
	public boolean validateByMernis(String nationalId, String firstName, String lastName, int yearOfBirth) {
		
		
		boolean result = true;
		
		try {
			result=fakeMernisManager.validateByPersonalInfo(nationalId, firstName, lastName, yearOfBirth);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}




	

	
	
	
	
	
}
