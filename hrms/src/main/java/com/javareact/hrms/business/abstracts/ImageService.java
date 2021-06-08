package com.javareact.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.Image;

public interface ImageService {
	Result add(Image jobSeekerImage,MultipartFile imageFile);
	Result update(Image imageForCv);
	Result delete(int id);
	DataResult<Image> getById(int id);
	DataResult<List<Image>> getAll();
	DataResult<Image> getByJobSeekerId(int id);
	
}
