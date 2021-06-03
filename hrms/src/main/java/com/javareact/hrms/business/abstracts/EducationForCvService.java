package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.EducationForCv;

public interface EducationForCvService {
Result add(EducationForCv educationForCv);

Result update(EducationForCv educationForCv);
Result delete(int id);
DataResult<List<EducationForCv>> getAll();
DataResult<EducationForCv>getById(int id);
DataResult<List<EducationForCv>> getByJobSeekerIdOrderByGraduationYearDesc(int id);
DataResult<List<EducationForCv>> getAllByJobSeekerId(int id);
}
