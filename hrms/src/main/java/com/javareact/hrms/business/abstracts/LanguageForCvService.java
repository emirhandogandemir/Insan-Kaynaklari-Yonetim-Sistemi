package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;

import com.javareact.hrms.entities.concretes.LanguageForCv;

public interface LanguageForCvService {
	Result add(LanguageForCv languageForCv);
	Result update(LanguageForCv languageForCv);
	Result delete(int id);
	DataResult<LanguageForCv> getById(int id);
	DataResult<List<LanguageForCv>> getAll();
	DataResult<List<LanguageForCv>>getAllByJobSeekerId(int id);
}
