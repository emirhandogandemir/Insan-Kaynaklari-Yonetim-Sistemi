package com.javareact.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_adverts")
public class JobAdvert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private int id;

//	@Column(name = "job_position_id")
//	private int jobPositionId;

//	@Column(name = "employer_id")
//	private int employerId;

//	@Column(name = "city_id")
//	private int cityId;

	@Column(name = "description")
	private String description;

	@Column(name = "salary_min")
	private int salaryMin;

	@Column(name = "salary_max")
	private int salaryMax;

	@Column(name = "open_position_count")
	private int openPositionCount;

	@Column(name = "deadline")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDateTime deadline;

	@Column(name = "published_at")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDateTime publishedAt;

	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	@JsonIgnore
	private LocalDate createdAt = LocalDate.now();

	@Column(name = "is_open", columnDefinition = "boolean default true")
	private boolean isOpen = true;

	@Column(name = "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;

	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;

	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
}
