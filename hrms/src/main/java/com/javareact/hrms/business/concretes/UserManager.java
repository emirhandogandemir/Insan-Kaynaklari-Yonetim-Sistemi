package com.javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javareact.hrms.business.abstracts.UserService;
import com.javareact.hrms.core.dataAccess.UserDao;
import com.javareact.hrms.core.entities.User;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.core.utilities.results.SuccessDataResult;
import com.javareact.hrms.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
	    return new SuccessResult("User has been added.");
	}
//
//	@Override
//	public Result update(User user) {
//		this.userDao.save(user);
//      return new SuccessResult("User has been updated.");
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.userDao.deleteById(id);
//      return new SuccessResult("User has been deleted.");
//	}
//
//	@Override
//	public DataResult<User> getById(int id) {
//		return new SuccessDataResult<User>(this.userDao.getOne(id));
//	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	@Override
	public DataResult<User> getUserByEmail(String email) {

		return new SuccessDataResult<User>(this.userDao.findUserByEmail(email));
	}
			
		
}
