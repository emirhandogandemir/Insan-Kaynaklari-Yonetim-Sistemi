package com.javareact.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.JobPositionService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.JobPosition;
import com.javareact.hrms.entities.concretes.JobSeeker;

@RestController
 @RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobPosition jobPosition){
		return ResponseEntity.ok(this.jobPositionService.add(jobPosition));
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody JobPosition jobPosition){
		return ResponseEntity.ok(this.jobPositionService.update(jobPosition));
	}
	
	@PostMapping("/delete")
	public Result delete(@PathVariable("id") int id){
		return this.jobPositionService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobPosition> getById(@PathVariable("id") int id){
		return this.jobPositionService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}
}
