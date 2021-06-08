package com.javareact.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.CityService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.*;

@RestController
@RequestMapping("/api/city")
@CrossOrigin
public class CitiesController {
	
	

		private CityService cityService;

		@Autowired
		public CitiesController(CityService cityService) {
			super();
			this.cityService = cityService;
		}
		
		@PostMapping("/add")
		public ResponseEntity<?> add(@Valid @RequestBody City city){
			return ResponseEntity.ok(this.cityService.add(city));
		} 
		
		
		@GetMapping("/getall")
		@Cacheable("allCities")
		public DataResult<List<City>> getAll(){
			System.out.println(">>>inside getCity... ");
			return this.cityService.getAll();
		}
}
//		@PostMapping("/update")
//		public ResponseEntity<?> update(@Valid @RequestBody City city){
//			return ResponseEntity.ok(this.cityService.update(city));
//		}
	//	
//		@PostMapping("/delete")
//		public Result delete(@PathVariable("id") int id){
//			return this.cityService.delete(id);
//		}
	//	
//		@GetMapping("/getbyid")
//		public DataResult<City> getById(@PathVariable("id") int id){
//			return this.cityService.getById(id);
//		}
	//	
		
