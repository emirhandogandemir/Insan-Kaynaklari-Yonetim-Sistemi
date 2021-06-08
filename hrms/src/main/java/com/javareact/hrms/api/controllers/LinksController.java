package com.javareact.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.LinkService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Link;

@RestController
@RequestMapping("/api/links")
@CrossOrigin
public class LinksController {
	private LinkService linkForCvService;

	@Autowired
	public LinksController(LinkService linkForCvService) {
		super();
		this.linkForCvService = linkForCvService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Link linkForCv){
		return this.linkForCvService.add(linkForCv);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Link linkForCV){
		return this.linkForCvService.update(linkForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.linkForCvService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Link> getById(@RequestParam("id") int id){
		return this.linkForCvService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Link>> getAll(){
		return this.linkForCvService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<Link>> getAllByJobseekerId(@RequestParam int id){
		return this.linkForCvService.getAllByJobSeekerId(id);
	}
}
