package com.javareact.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cv_cover_letters")
@NoArgsConstructor
public class CoverLetterForCv extends Base{


	@Column(name = "content")
	private String content;
	
	public CoverLetterForCv(String content, int jobseekerId) {
		super();
		this.content = content;
		this.jobSeeker.setId(jobseekerId);
	}

	@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	//@JsonIgnore
	private JobSeeker jobSeeker;
}
