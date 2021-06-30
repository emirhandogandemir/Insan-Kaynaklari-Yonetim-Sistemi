package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

Result update(JobPosition jobPosition);
Result delete(int id);
DataResult<JobPosition> getById(int id);

long countGetAll();

Result add(JobPosition jobPosition);
DataResult<List <JobPosition>> getAll();
DataResult<JobPosition> getJobByTitle(String title);
}
