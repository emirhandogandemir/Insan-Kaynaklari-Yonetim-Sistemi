package com.javareact.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.LinkForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.LinkForCv;

@RestController
@RequestMapping("/api/links")
public class LinksController {
	private LinkForCvService linkForCvService;

	@Autowired
	public LinksController(LinkForCvService linkForCvService) {
		super();
		this.linkForCvService = linkForCvService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LinkForCv linkForCv){
		return this.linkForCvService.add(linkForCv);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody LinkForCv linkForCV){
		return this.linkForCvService.update(linkForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.linkForCvService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<LinkForCv> getById(@RequestParam("id") int id){
		return this.linkForCvService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<LinkForCv>> getAll(){
		return this.linkForCvService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<LinkForCv>> getAllByJobseekerId(@RequestParam int id){
		return this.linkForCvService.getAllByJobSeekerId(id);
	}
}
