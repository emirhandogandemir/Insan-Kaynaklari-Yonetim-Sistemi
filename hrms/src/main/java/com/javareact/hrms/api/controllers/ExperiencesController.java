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

import com.javareact.hrms.business.abstracts.ExperienceService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Experience;
import com.javareact.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/experiences/")
@CrossOrigin
public class ExperiencesController {

	private ExperienceService experienceForCvService;

	@Autowired
	public ExperiencesController(ExperienceService experienceForCvService) {
		super();
		this.experienceForCvService = experienceForCvService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Experience experienceForCv) {
		return ResponseEntity.ok(this.experienceForCvService.add(experienceForCv));
	}
	
	@PostMapping("update")
	public ResponseEntity<?> update( @Valid @RequestBody Experience experienceForCv) {
		return ResponseEntity.ok(this.experienceForCvService.update(experienceForCv));
	}
	
	 @PostMapping("delete")
	 public Result delete(@RequestParam("id") int id) {
		 return this.experienceForCvService.delete(id);
	 }
	 @GetMapping("getbyid")
	 public DataResult<Experience> getById(@RequestParam int id){
		 return this.experienceForCvService.getById(id);
	 }
	 @GetMapping("getAllByJobSeekerIdOrderByLeaveAtDesc")
	 public DataResult<List<Experience>> getAllByJobSeekerIdOrderByLeaveArDesc(@RequestParam("id") int id){
		 return this.experienceForCvService.getAllByJobSeekerIdOrderByLeaveDateDesc(id);
	 }
	 
	 @GetMapping("getAllJobSeekerId")
	 public DataResult<List<Experience>> getAllByJobSeekerId(@RequestParam int id){
		 return this.experienceForCvService.getAllByJobSeekerId(id);
	 }
	 
}
