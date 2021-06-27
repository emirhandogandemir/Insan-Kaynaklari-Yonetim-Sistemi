package com.javareact.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.List;

import com.javareact.hrms.entities.concretes.CoverLetter;
import com.javareact.hrms.entities.concretes.Education;
import com.javareact.hrms.entities.concretes.Experience;
import com.javareact.hrms.entities.concretes.Image;
import com.javareact.hrms.entities.concretes.JobSeeker;
import com.javareact.hrms.entities.concretes.Language;
import com.javareact.hrms.entities.concretes.Link;
import com.javareact.hrms.entities.concretes.Skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCvDto {
	public JobSeeker jobSeeker;
	public List<Education> educations;
	public List<Skill> skills;
	public List<Link> links;
	public List<Language> languages;
	public List<Experience> experiences;
	public List<CoverLetter> coverletters;
	public Image image;
}
