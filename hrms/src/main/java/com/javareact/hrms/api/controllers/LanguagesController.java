package com.javareact.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.LanguageService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Language;
import com.javareact.hrms.entities.concretes.Link;

@RestController
@RequestMapping("api/languages/")
@CrossOrigin
public class LanguagesController {

	private LanguageService languageForCvService;

	@Autowired
	public LanguagesController(LanguageService laguageForCvService) {
		super();
		this.languageForCvService = laguageForCvService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add (@Valid @RequestBody Language languageForCv) {
		return ResponseEntity.ok(this.languageForCvService.add(languageForCv));
	}
	
	
	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Language languageForCv) {
		return ResponseEntity.ok(this.languageForCvService.update(languageForCv));
	}
	
	@PostMapping("delete")
	public Result delete (@RequestParam("id") int id) {
		return this.languageForCvService.delete(id);
	}
	
	@GetMapping("getbyid")
	public DataResult<Language> getById(@RequestParam("id") int id ) {
		return this.languageForCvService.getById(id);
	}
	@GetMapping("getall")
	public DataResult<List<Language>> getAll(){
		return this.languageForCvService.getAll();
	}
	
	@GetMapping("getAllByJobSeekerId")
	public DataResult<List<Language>> getAllByJobSeekerId(@RequestParam int id){
		return this.languageForCvService.getAllByJobSeekerId(id);
				
	}
}
