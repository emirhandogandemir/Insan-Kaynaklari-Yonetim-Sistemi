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
import org.springframework.web.multipart.MultipartFile;

import com.google.common.net.MediaType;

import com.javareact.hrms.business.abstracts.ImageService;
import com.javareact.hrms.business.abstracts.JobSeekerService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Image;
import com.javareact.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/images/")
@CrossOrigin
public class ImagesController {

	private ImageService imageForCvService;
	private JobSeekerService jobSeekerService;

	@Autowired
	public ImagesController(ImageService imageForCvService, JobSeekerService jobSeekerService) {
		super();
		this.imageForCvService = imageForCvService;
		this.jobSeekerService = jobSeekerService;
	}

	@PostMapping("add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		JobSeeker jobSeeker = this.jobSeekerService.getById(id).getData();
		Image imageForCv = new Image();
		imageForCv.setJobSeeker(jobSeeker);
		return this.imageForCvService.add(imageForCv, imageFile);
	}

	@PostMapping("update")
	public Result update(@RequestBody Image imageForCv) {
		return this.imageForCvService.update(imageForCv);
	}

	@PostMapping("delete")
	public Result delete(@RequestParam("id") int id) {
		return this.imageForCvService.delete(id);
	}

	@GetMapping("getbyid")
	public DataResult<Image> getById(@RequestParam("id") int id) {
		return this.imageForCvService.getById(id);
	}

	@GetMapping("getall")
	public DataResult<List<Image>> getAll() {
		return this.imageForCvService.getAll();
	}

	@GetMapping("getByJobSeekerId")
	public DataResult<Image> getByJobSeekerId(@RequestParam int id) {
		return this.imageForCvService.getByJobSeekerId(id);
	}

}
