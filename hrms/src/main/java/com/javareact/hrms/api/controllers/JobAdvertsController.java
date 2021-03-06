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

import com.javareact.hrms.business.abstracts.JobAdvertService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.entities.concretes.JobAdvert;
import com.javareact.hrms.entities.concretes.JobPosition;
import com.javareact.hrms.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	
	@PostMapping("/add")
	
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertDto jobAdvert){
		return ResponseEntity.ok(this.jobAdvertService.add(jobAdvert));
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody JobAdvert jobAdvert){
		return ResponseEntity.ok(this.jobAdvertService.update(jobAdvert));
	}
	
	@PostMapping("/delete")
	public Result delete(@PathVariable("id") int id){
		return this.jobAdvertService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(@RequestParam int id){
		return this.jobAdvertService.getById(id);
	}
	
	@GetMapping("/getAll")
	@Cacheable("allJobAdverts")
	public DataResult<List<JobAdvert>> getAll(){	
		System.out.println(">>>inside getJobAdverts... ");
		return this.jobAdvertService.getAll();
	}
	
	//onaylama
	// 	-----------------------
	@PostMapping("/changeactivestatus")
	public Result changeIsActiveByEmployee(@RequestParam int id) {
		return this.jobAdvertService.changeIsActiveByEmployee(id);
	}

	@PostMapping("/changeopenstatus")
	public Result changeIsOpenByEmployer(@RequestParam int id) {
		return this.jobAdvertService.changeIsOpenByEmployer(id);
	}
	
	@GetMapping("/getAllActiveAndOpenJobAdverts")
	public DataResult<List<JobAdvert>> getAllByIsActiveByEmployee(@RequestParam int pageNo,@RequestParam int size){
		return this.jobAdvertService.getAllByIsActiveByEmployee(pageNo,size);
	}
	
	@GetMapping("/getAllOpenJobAdvertsAndIsActiveFalse")
	public DataResult<List<JobAdvert>> getAllByIsActiveByEmployee_False(){
		return this.jobAdvertService.getAllByIsActiveByEmployee_False();
	}
	
	@GetMapping("/getAllByEmployerId")
	public DataResult<List<JobAdvert>> getAllByEmployerId(@RequestParam int id){
		//System.out.println(">>>inside getJobAdvertsEmployerId... ");
		return this.jobAdvertService.getAllByEmployerId(id);
	}
	
	
	@GetMapping("/getAllByCityId")
	public DataResult<List<JobAdvert>> getAllByCityId(@RequestParam int cityId){
		return this.jobAdvertService.getAllByCityId(cityId);
	}
	
	@GetMapping("/getAllByWorkTypeId")
	public DataResult<List<JobAdvert>> getAllByWorkTypeId(@RequestParam int workTypeId){
		return this.jobAdvertService.getAllByWorkTypeId(workTypeId);
	}
	
	@GetMapping("/getAllByCityIdAndWorkTypeId")
	public DataResult<List<JobAdvert>> getAllByCityIdAndWorkTypeId(@RequestParam int cityId,@RequestParam int workTypeId){
		return this.jobAdvertService.getAllByCityIdAndWorkTypeId(cityId, workTypeId);
	}
	@GetMapping("/countByJobPositionId")
	public long countByJobPosition_Id(@RequestParam int jobPositionId) {
		return this.jobAdvertService.countByJobPosition_Id(jobPositionId);
	}
	@GetMapping("countGetAll")
	public long countGetAll() {
		return this.jobAdvertService.countGetAll();
	}
	

}