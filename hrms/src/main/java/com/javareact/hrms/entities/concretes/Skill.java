package com.javareact.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cv_skills")
public class Skill extends Base {


	
	@Column(name="name")
	@NotNull
	@NotBlank
	private String name;
	
	@ManyToOne()
	//@JsonIgnore
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	
	
}
