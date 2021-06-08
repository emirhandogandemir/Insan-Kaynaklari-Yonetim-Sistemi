package com.javareact.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cv_foreign_languages")
public class Language extends Base{

	
	
	@Column(name = "language")
	private String language;

	@Column(name = "level")
	@Min(1)
	@Max(5)
	@NotNull
	private short level;



	@ManyToOne()
	 //@JsonIgnore()
	@JoinColumn(name = "jobseeker_id")
	private JobSeeker jobSeeker;
}
