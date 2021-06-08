package com.javareact.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javareact.hrms.business.abstracts.ImageService;
import com.javareact.hrms.core.utilities.imageUpload.ImageUploadService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.ImageDao;
import com.javareact.hrms.entities.concretes.Image;
@Service
public class ImageManager implements ImageService {

	private ImageDao imageForCvDao;
	private ImageUploadService imageUploadService;
	
	

@Autowired
	public ImageManager(ImageDao imageForCvDao, ImageUploadService imageUploadService) {
		super();
		this.imageForCvDao = imageForCvDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public DataResult<List<Image>> getAll() {
	return new SuccessDataResult<List<Image>>(this.imageForCvDao.findAll());
	}

	@Override
	public Result add(Image imageForCv, MultipartFile imageFile) {
		Map<String,String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		imageForCv.setUrl(uploadImage.get("url"));
		this.imageForCvDao.save(imageForCv);
		return new SuccessResult("Image has been added.");
	}

	@Override
	public Result update(Image imageForCv) {
		this.imageForCvDao.save(imageForCv);
		return new SuccessResult("Image has been updated");
	}

	@Override
	public Result delete(int id) {
		this.imageForCvDao.deleteById(id);
		return new SuccessResult("image has been deleted");
	}

	@Override
	public DataResult<Image> getById(int id) {
		return new SuccessDataResult<Image>(this.imageForCvDao.getById(id));
	}

	@Override
	public DataResult<Image> getByJobSeekerId(int id) {
		return new SuccessDataResult<Image>(this.imageForCvDao.getByJobSeeker_id(id));
	}

}
