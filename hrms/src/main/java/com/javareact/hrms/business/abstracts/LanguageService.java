package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;

import com.javareact.hrms.entities.concretes.Language;

public interface LanguageService {
	Result add(Language languageForCv);
	Result update(Language languageForCv);
	Result delete(int id);
	DataResult<Language> getById(int id);
	DataResult<List<Language>> getAll();
	DataResult<List<Language>>getAllByJobSeekerId(int id);
}
