package com.javareact.hrms.core.utilities.adapters;

import java.time.LocalDate;

import com.javareact.hrms.entities.concretes.JobSeeker;

public interface MernisService {

	boolean validateByMernis(String nationalId, String firstName, String lastName, int yearOfBirth);
}
