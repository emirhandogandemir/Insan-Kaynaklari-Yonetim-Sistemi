package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
Result add(CoverLetter coverLetterForCv);
Result update(CoverLetter coverLetterForCv);
Result delete(int id);
DataResult<CoverLetter> getById(int id);
DataResult<List<CoverLetter>> getAll();
}
