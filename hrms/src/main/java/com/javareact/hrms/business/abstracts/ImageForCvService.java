package com.javareact.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.ImageForCv;

public interface ImageForCvService {
	Result add(ImageForCv jobSeekerImage,MultipartFile imageFile);
	Result update(ImageForCv imageForCv);
	Result delete(int id);
	DataResult<ImageForCv> getById(int id);
	DataResult<List<ImageForCv>> getAll();
	DataResult<ImageForCv> getByJobSeekerId(int id);
	
}
