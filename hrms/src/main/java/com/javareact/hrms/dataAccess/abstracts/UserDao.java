package com.javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import com.javareact.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer> {
	User findUserByEmail(String email);
	//veritaanında Email arıyor
	User findById(int id);
	//@Modifying()
	//@Query("delete from User where b.id=:id")
	//void deleteUsers(@Param("id") int id);
}
