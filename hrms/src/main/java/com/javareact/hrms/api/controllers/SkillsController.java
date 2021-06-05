package com.javareact.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.SkillForCvService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.SkillForCv;

@RestController
@RequestMapping("/api/skills/")
public class SkillsController {
	private SkillForCvService skillForCvService;

	 @Autowired
	public SkillsController(SkillForCvService skillForCvService) {
		super();
		this.skillForCvService = skillForCvService;
	}
	 
	 
	 @PostMapping("add")
		public Result add(@RequestBody SkillForCv skillForCv){
			return this.skillForCvService.add(skillForCv);
		}
		
		@PostMapping("update")
		public Result update(@RequestBody SkillForCv skillForCv){
			return this.skillForCvService.update(skillForCv);
		}
		
		@PostMapping("delete")
		public Result delete(@RequestParam("id") int id){
			return this.skillForCvService.delete(id);
		}
		
		@GetMapping("getbyid")
		public DataResult<SkillForCv> getById(@RequestParam("id") int id){
			return this.skillForCvService.getById(id);
		}
		
		@GetMapping("getall")
		public DataResult<List<SkillForCv>> getAll(){
			return this.skillForCvService.getAll();
		}
		
		@GetMapping("/getAllByJobseekerId")
		public DataResult<List<SkillForCv>> getAllByJobseekerId(@RequestParam int id){
			return this.skillForCvService.getAllByJobSeekerId(id);
		}
}
