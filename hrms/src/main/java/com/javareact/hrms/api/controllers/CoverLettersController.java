package com.javareact.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.CoverLetterForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.CoverLetterForCv;

@RestController
@RequestMapping("/api/coverletters/")
public class CoverLettersController {

	private CoverLetterForCvService coverLettersForCvService;

	@Autowired
	public CoverLettersController(CoverLetterForCvService coverLettersForCvService) {
		super();
		this.coverLettersForCvService = coverLettersForCvService;
	}
	
	
	@PostMapping("add")
	public Result add(@RequestBody CoverLetterForCv coverLetterForCv) {
		return this.coverLettersForCvService.add(coverLetterForCv);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody CoverLetterForCv coverLetterForCv) {
		return this.coverLettersForCvService.update(coverLetterForCv)	;
		
	}
	@PostMapping("delete")
	public Result delete(@RequestParam("id") int id) {
		return this.coverLettersForCvService.delete(id);
		
	}
	
	@GetMapping("getbyid")
	public DataResult<CoverLetterForCv> getById(@RequestParam("id") int id){
		return this.coverLettersForCvService.getById(id);
	}
	
	@GetMapping("getall")
	public DataResult<List<CoverLetterForCv>> getAll(){
		return this.coverLettersForCvService.getAll();
	}
}
