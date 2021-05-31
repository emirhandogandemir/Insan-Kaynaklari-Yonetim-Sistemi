package com.javareact.hrms.business.abstracts;

import java.util.List;

import com.javareact.hrms.core.entities.User;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;

public interface UserService {
DataResult<List<User>> getAll();
Result add(User user);
DataResult<User> getUserByEmail(String email);
}
