package com.javareact.hrms.fakeMernisService;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class FakeMernisManager {
	//Mernis şu anda sadece identityNumberı kontrol ediyor
	public boolean validateByPersonalInfo(String nationalId, String firstName, String lastName, int yearOfBirth)
	{
		System.out.println(firstName + " " + lastName + " is valid person." );
		return true;
	}
	

}
