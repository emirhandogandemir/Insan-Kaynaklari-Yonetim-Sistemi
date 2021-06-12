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

import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.WorkHourService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.entities.concretes.WorkHour;

@RestController
@RequestMapping("/api/workhours/")
@CrossOrigin
public class WorkHoursController {

	private WorkHourService workHourService;

	@Autowired
	public WorkHoursController(WorkHourService workHourService) {
		super();
		this.workHourService = workHourService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody WorkHour workHour){
		return ResponseEntity.ok(this.workHourService.add(workHour));
	}
	
	@GetMapping("getall")
	public DataResult<List<WorkHour>> getAll(){
		return this.workHourService.getAll();
	}
}
