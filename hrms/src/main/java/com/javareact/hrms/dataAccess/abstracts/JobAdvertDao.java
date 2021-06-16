package com.javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javareact.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

	@Query("From JobAdvert where isOpen = true")// iş veren tarafından eklenilen sadece 
	List<JobAdvert> getAllOpenJobAdvertList();
	
	
	@Query("From JobAdvert where isOpen = true Order By publishedAt Desc") // iş veren tarafından verilen ilanın tarihsel sıraya göre gelmesi
	List<JobAdvert> findAllByOrderByPublishedAtDesc();
	
	@Query("From JobAdvert where isOpen = true and employer_id =:id")//iş ilanının employer iye göre gelmesi
	List<JobAdvert> getAllOpenJobAdvertByEmployer(int id);
	
	@Query("From JobAdvert where is_active=true AND is_open=true Order By published_at DESC")// iş arayanın göreceği 1.sayfa
	List<JobAdvert> getAllByIsActiveByEmployee();
	
	@Query("From JobAdvert where is_active=false And is_open=true Order By published_at DESC")//active edilmemiş ADMİN GÖRÜCEK
	List <JobAdvert> getAllByIsActiveByEmployee_False();
	
	 
	JobAdvert getById(int id);
	
	
	List<JobAdvert> getAllByEmployerId(int employerId);
	
	
	JobAdvert findById(int id);

}
