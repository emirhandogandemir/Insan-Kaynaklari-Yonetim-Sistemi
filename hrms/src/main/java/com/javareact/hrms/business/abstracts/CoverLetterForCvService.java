package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.CoverLetterForCv;

public interface CoverLetterForCvService {
Result add(CoverLetterForCv coverLetterForCv);
Result update(CoverLetterForCv coverLetterForCv);
Result delete(int id);
DataResult<CoverLetterForCv> getById(int id);
DataResult<List<CoverLetterForCv>> getAll();
}
