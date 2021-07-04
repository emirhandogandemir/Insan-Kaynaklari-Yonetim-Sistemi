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

import com.javareact.hrms.business.abstracts.FavoriteService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Experience;
import com.javareact.hrms.entities.concretes.Favorite;

@RestController
@RequestMapping("/api/favorites/")
@CrossOrigin
public class FavoritesController {

	private FavoriteService favoriteService;

	@Autowired
	public FavoritesController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Favorite favorite) {
		return ResponseEntity.ok(this.favoriteService.add(favorite));
	}
	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Favorite favorite) {
		return ResponseEntity.ok(this.favoriteService.update(favorite));
	}
	
	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.favoriteService.delete(id);
	}
	
	@GetMapping("getall")
	public DataResult<List<Favorite>> getAll(){
		return this.favoriteService.getAll();
	}
	
	@GetMapping("getById")
	public DataResult<Favorite> getById(@RequestParam int id){
		return this.favoriteService.getById(id);
	}
	
	@GetMapping("getByJobSeekerId")
	public DataResult<List<Favorite>> getByJobSeekerId(@RequestParam int jobSeekerId){
		return this.favoriteService.getByJobSeekerId(jobSeekerId);
	}
	
	@GetMapping("getByAdvertId")
	public DataResult<List<Favorite>> getByAdvertId(@RequestParam int jobAdvertId){
		return this.favoriteService.getByJobAdvertId(jobAdvertId);
	}
	@GetMapping("getByJobAdvertIdAndJobSeekerId")
	public DataResult<Favorite> getByJobAdvert_IdAndJobSeeker_Id(@RequestParam ("jobAdvertId") int jobAdvertId,@RequestParam ("jobSeekerId") int jobSeekerId){
		return this.favoriteService.getByJobAdvert_IdAndJobSeeker_Id(jobAdvertId, jobSeekerId);
	}
}
