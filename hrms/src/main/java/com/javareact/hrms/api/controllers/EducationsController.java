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

import com.javareact.hrms.business.abstracts.EducationService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations/")
@CrossOrigin
public class EducationsController {
		
	private EducationService educationForCvService;
@Autowired
	public EducationsController(EducationService educationForCvService) {
		super();
		this.educationForCvService = educationForCvService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Education educaitonForCv) {
		return ResponseEntity.ok(this.educationForCvService.add(educaitonForCv));
	}
	
	@PostMapping("update")
	public ResponseEntity<?> update( @Valid @RequestBody Education educationForCv) {
		return ResponseEntity.ok(this.educationForCvService.update(educationForCv));
	}
	
	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.educationForCvService.delete(id);
	}
	
	@GetMapping("getbyid")
	public DataResult<Education> getByID(@RequestParam int id){
		return this.educationForCvService.getById(id);
	}
	
	@GetMapping("getall")
	public DataResult<List<Education>> getAll() {
		return this.educationForCvService.getAll();
	}
	
	@GetMapping("getAllByJobSeekerIdOrderByGraduationAtDesc")
	public DataResult<List<Education>> getAllByJobSeekerIdOrderByGraduationAtDesc (@RequestParam int id){
		return this.educationForCvService.getByJobSeekerIdOrderByGraduationYearDesc(id);
	}
	@GetMapping("getAllByJobSeekerId")
	public DataResult<List<Education>> getAllByJobSeekerId(@RequestParam int id){
		return this.educationForCvService.getAllByJobSeekerId(id);
	}
}
