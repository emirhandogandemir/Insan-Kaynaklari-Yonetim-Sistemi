package com.javareact.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.EducationForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.EducationForCv;

@RestController
@RequestMapping("/api/educations/")
public class EducationsController {
		
	private EducationForCvService educationForCvService;
@Autowired
	public EducationsController(EducationForCvService educationForCvService) {
		super();
		this.educationForCvService = educationForCvService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody EducationForCv educaitonForCv) {
		return this.educationForCvService.add(educaitonForCv);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody EducationForCv educationForCv) {
		return this.educationForCvService.update(educationForCv);
	}
	
	@PostMapping("delete")
	public Result delete(@RequestParam("id") int id) {
		return this.educationForCvService.delete(id);
	}
	
	@GetMapping("getbyid")
	public DataResult<EducationForCv> getByID(@RequestParam int id){
		return this.educationForCvService.getById(id);
	}
	@GetMapping("getall")
	public DataResult<List<EducationForCv>> getAll() {
		return this.educationForCvService.getAll();
	}
	
	@GetMapping("getAllByJobSeekerIdOrderByGraduationAtDesc")
	public DataResult<List<EducationForCv>> getAllByJobSeekerIdOrderByGraduationAtDesc (@RequestParam int id){
		return this.educationForCvService.getByJobSeekerIdOrderByGraduationYearDesc(id);
	}
	@GetMapping("getAllByJobSeekerId")
	public DataResult<List<EducationForCv>> getAllByJobSeekerId(@RequestParam int id){
		return this.educationForCvService.getAllByJobSeekerId(id);
	}
}
