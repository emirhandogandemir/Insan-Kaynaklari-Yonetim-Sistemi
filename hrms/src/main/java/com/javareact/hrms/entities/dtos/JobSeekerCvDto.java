package com.javareact.hrms.entities.dtos;

import java.util.List;

import com.javareact.hrms.entities.concretes.Education;
import com.javareact.hrms.entities.concretes.Experience;
import com.javareact.hrms.entities.concretes.Image;
import com.javareact.hrms.entities.concretes.JobSeeker;
import com.javareact.hrms.entities.concretes.Language;
import com.javareact.hrms.entities.concretes.Link;
import com.javareact.hrms.entities.concretes.Skill;

public class JobSeekerCvDto {
	public JobSeeker jobSeeker;
	public List<Education> educations;
	public List<Skill> skills;
	public List<Link> links;
	public List<Language> languages;
	public List<Experience> experiences;
	public Image image;
}
