package com.javareact.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.UserService;
import com.javareact.hrms.core.entities.User;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessResult;

@RestController
@RequestMapping("/api/users/")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping(value="add")
	public ResponseEntity<?>add(@Valid @RequestBody User user){
		 return ResponseEntity.ok(this.userService.add(user));
	}
	
//	@PostMapping("/update")
//	public Result update(@RequestBody User user){
//		return this.userService.update(user);
//	}
//	
//	@PostMapping("/delete")
//	public Result delete(@PathVariable("id") int id){
//		return this.userService.delete(id);
//	}
//	
//	@GetMapping("/getbyid")
//	public DataResult<User> getById(@PathVariable("id") int id){
//		return this.userService.getById(id);
//	}
//	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	
}
