package com.javareact.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javareact.hrms.core.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobseekers")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdverts" })
public class JobSeeker extends User {

//	@Id
//	@GeneratedValue
//	@Column(name= "user_id")
//	private int userId;

	@Column(name = "first_name")
	@NotNull(message = "firstname cannot be null")
	@NotBlank
	@Size(min = 3, max = 30, message = "About Me must be between 3 and 30 characters")
	private String firstName;

	@Column(name = "last_name")
	@NotNull(message = "lastName cannot be null")
	@NotBlank
	@Size(min = 3, max = 30, message = "About Me must be between 3 and 30 characters")
	private String lastName;

	@Column(name = "national_id")
	@Min(value = 11)
	@Max(value = 11)
	private String nationalId;


	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<LanguageForCv> languages;
	
	@JsonIgnore
	@OneToOne(mappedBy = "jobSeeker", optional=false, fetch=FetchType.LAZY)
	private ImageForCv image;
	
	@OneToMany(mappedBy="jobSeeker")
	@JsonIgnore
	private List<EducationForCv> educations;
	
	@OneToMany(mappedBy="jobSeeker")
	@JsonIgnore
	private List<ExperienceForCv> experiences;
	
	@OneToMany(mappedBy="jobSeeker")
	@JsonIgnore
	private List<SkillForCv> skills;
	
	@OneToMany(mappedBy="jobSeeker")
	@JsonIgnore
	private List<CoverLetterForCv> coverLetters;
	
	@Column(name = "date_of_birth")
	@Past
	private LocalDateTime dateOfBirth;

	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;

}
