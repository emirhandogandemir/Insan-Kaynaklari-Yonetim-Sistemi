package com.javareact.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.EmployerService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Employer;
import com.javareact.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer){
		return ResponseEntity.ok(this.employerService.add(employer));
	}
	
	
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Employer employer){
		return ResponseEntity.ok(this.employerService.update(employer));
	}
	
	@PostMapping("/delete")
	public Result delete(@PathVariable("id") int id){
		return this.employerService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Employer> getById(@RequestParam int id){
		return this.employerService.getById(id);
	}
	
	@GetMapping("/getall")
	@Cacheable("allEmployers")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("/getallbyverify")
	public DataResult<List<Employer>> getAllByVerify(){
	return this.employerService.getAllByVerify(); 
	}
	
	@PostMapping("/changeverifiedstatus")
	public Result changeIsVerifiedByEmployee(@RequestParam int id) {
		return this.employerService.changeIsVerifiedByEmployee(id);
	}
	@GetMapping("countById")
	public long  countById(@RequestParam int id) {
		return this.employerService.countById(id);
	}
	
	@GetMapping("countGetAll")
	public long  countGetALL() {
		return this.employerService.countGetAll();
	}
	
}
