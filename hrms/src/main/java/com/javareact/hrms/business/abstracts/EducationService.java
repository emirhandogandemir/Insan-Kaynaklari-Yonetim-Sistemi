package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Education;

public interface EducationService {
Result add(Education educationForCv);

Result update(Education educationForCv);
Result delete(int id);
DataResult<List<Education>> getAll();
DataResult<Education>getById(int id);
DataResult<List<Education>> getByJobSeekerIdOrderByGraduationYearDesc(int id);
DataResult<List<Education>> getAllByJobSeekerId(int id);
}
