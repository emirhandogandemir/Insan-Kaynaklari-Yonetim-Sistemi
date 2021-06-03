package com.javareact.hrms.entities.dtos;

import java.util.List;

import com.javareact.hrms.entities.concretes.EducationForCv;
import com.javareact.hrms.entities.concretes.ExperienceForCv;
import com.javareact.hrms.entities.concretes.ImageForCv;
import com.javareact.hrms.entities.concretes.JobSeeker;
import com.javareact.hrms.entities.concretes.LanguageForCv;
import com.javareact.hrms.entities.concretes.LinkForCv;
import com.javareact.hrms.entities.concretes.SkillForCv;

public class JobSeekerCvDto {
	public JobSeeker jobSeeker;
	public List<EducationForCv> educations;
	public List<SkillForCv> skills;
	public List<LinkForCv> links;
	public List<LanguageForCv> languages;
	public List<ExperienceForCv> experiences;
	public ImageForCv image;
}
