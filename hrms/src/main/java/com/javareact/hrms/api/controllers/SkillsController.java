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

import com.javareact.hrms.business.abstracts.SkillService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Link;
import com.javareact.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills/")
@CrossOrigin
public class SkillsController {
	private SkillService skillForCvService;

	 @Autowired
	public SkillsController(SkillService skillForCvService) {
		super();
		this.skillForCvService = skillForCvService;
	}
	 
	 
	 @PostMapping("add")
		public ResponseEntity<?> add(@Valid @RequestBody Skill skillForCv){
		 return ResponseEntity.ok(this.skillForCvService.add(skillForCv));
		}
	 
	
		@PostMapping("update")
		public ResponseEntity<?> update(@Valid @RequestBody Skill skillForCv){
			return ResponseEntity.ok(this.skillForCvService.update(skillForCv));
		}
		
		@PostMapping("delete")
		public Result delete(@RequestParam("id") int id){
			return this.skillForCvService.delete(id);
		}
		
		@GetMapping("getbyid")
		public DataResult<Skill> getById(@RequestParam("id") int id){
			return this.skillForCvService.getById(id);
		}
		
		@GetMapping("getall")
		public DataResult<List<Skill>> getAll(){
			return this.skillForCvService.getAll();
		}
		
		@GetMapping("/getAllByJobseekerId")
		public DataResult<List<Skill>> getAllByJobseekerId(@RequestParam int id){
			return this.skillForCvService.getAllByJobSeekerId(id);
		}
}
