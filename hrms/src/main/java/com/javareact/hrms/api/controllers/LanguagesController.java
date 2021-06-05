package com.javareact.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.LanguageForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.LanguageForCv;

@RestController
@RequestMapping("api/languages/")
public class LanguagesController {

	private LanguageForCvService languageForCvService;

	@Autowired
	public LanguagesController(LanguageForCvService laguageForCvService) {
		super();
		this.languageForCvService = laguageForCvService;
	}
	
	@PostMapping("add")
	public Result add (@RequestBody LanguageForCv languageForCv) {
		return this.languageForCvService.add(languageForCv);
	}
	@PostMapping("update")
	public Result update(@RequestBody LanguageForCv languageForCv) {
		return this.languageForCvService.update(languageForCv);
	}
	
	@PostMapping("delete")
	public Result delete (@RequestParam("id") int id) {
		return this.languageForCvService.delete(id);
	}
	
	@GetMapping("getbyid")
	public DataResult<LanguageForCv> getById(@RequestParam("id") int id ) {
		return this.languageForCvService.getById(id);
	}
	@GetMapping("getall")
	public DataResult<List<LanguageForCv>> getAll(){
		return this.languageForCvService.getAll();
	}
	
	@GetMapping("getAllByJobSeekerId")
	public DataResult<List<LanguageForCv>> getAllByJobSeekerId(@RequestParam int id){
		return this.languageForCvService.getAllByJobSeekerId(id);
				
	}
}
