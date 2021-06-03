package com.javareact.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User,Integer> {
	User findUserByEmail(String email);
	//veritaanında Email arıyor
	User findById(int id);
	User findByEmail(String email);
	//@Modifying()
	//@Query("delete from User where b.id=:id")
	//void deleteUsers(@Param("id") int id);
}
