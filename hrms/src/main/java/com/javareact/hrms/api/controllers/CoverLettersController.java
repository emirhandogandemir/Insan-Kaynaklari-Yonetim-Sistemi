package com.javareact.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.CoverLetterService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/coverletters/")
public class CoverLettersController {

	private CoverLetterService coverLettersForCvService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLettersForCvService) {
		super();
		this.coverLettersForCvService = coverLettersForCvService;
	}
	
	
	@PostMapping("add")
	public Result add(@RequestBody CoverLetter coverLetterForCv) {
		return this.coverLettersForCvService.add(coverLetterForCv);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody CoverLetter coverLetterForCv) {
		return this.coverLettersForCvService.update(coverLetterForCv)	;
		
	}
	@PostMapping("delete")
	public Result delete(@RequestParam("id") int id) {
		return this.coverLettersForCvService.delete(id);
		
	}
	
	@GetMapping("getbyid")
	public DataResult<CoverLetter> getById(@RequestParam("id") int id){
		return this.coverLettersForCvService.getById(id);
	}
	
	@GetMapping("getall")
	public DataResult<List<CoverLetter>> getAll(){
		return this.coverLettersForCvService.getAll();
	}
}
