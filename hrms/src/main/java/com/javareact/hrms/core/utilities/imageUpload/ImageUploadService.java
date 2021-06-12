package com.javareact.hrms.core.utilities.imageUpload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.javareact.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {
	
	@SuppressWarnings("rawtypes")
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
	
}
