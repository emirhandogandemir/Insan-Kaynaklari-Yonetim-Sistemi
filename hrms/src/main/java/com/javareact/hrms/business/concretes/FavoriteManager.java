package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.FavoriteService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;
import com.javareact.hrms.dataAccess.abstracts.FavoriteDao;
import com.javareact.hrms.entities.concretes.Favorite;
@Service
public class FavoriteManager implements FavoriteService {

	private FavoriteDao favoriteDao;
	
	@Autowired
	public FavoriteManager(FavoriteDao favoriteDao) {
		super();
		this.favoriteDao = favoriteDao;
	}

	@Override
	public Result add(Favorite favorite) {
		this.favoriteDao.save(favorite);
		return new SuccessResult("Favorilere eklendi");
	}

	@Override
	public Result update(Favorite favorite) {
		this.favoriteDao.save(favorite);
		return new SuccessResult("Favori güncellendi");
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Favorite> getById(int id) {
	
		return new SuccessDataResult<Favorite>(this.favoriteDao.getById(id));
	}

	@Override
	public DataResult<List<Favorite>> getAll() {
		return new SuccessDataResult<List<Favorite>>(this.favoriteDao.findAll());
	}

	@Override
	public DataResult<List<Favorite>> getByJobSeekerId(int jobSeekerId) {
	return new SuccessDataResult<List<Favorite>>(this.favoriteDao.getByJobSeeker_Id(jobSeekerId));
	}

	@Override
	public DataResult<List<Favorite>> getByJobAdvertId(int jobAdvertId) {
		return new SuccessDataResult<List<Favorite>>(this.favoriteDao.getByJobAdvert_Id(jobAdvertId));
	}

}
