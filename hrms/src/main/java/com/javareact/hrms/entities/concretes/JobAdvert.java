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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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


	@Column(name = "description")
	@NotNull
	@NotBlank
	private String description;

	@Column(name = "salary_min")
	private int salaryMin;

	@Column(name = "salary_max")
	private int salaryMax;

	@Column(name = "open_position_count")
	@Min(value=1)
	private int openPositionCount;

	@Column(name = "deadline")
	@Future
	private LocalDateTime deadline;

	@Column(name = "published_at")
	private LocalDateTime publishedAt;

	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	@JsonIgnore
	private LocalDate createdAt = LocalDate.now();

	@Column(name = "is_open", columnDefinition = "boolean default true")
	private boolean isOpen = true;

	@Column(name = "is_active", columnDefinition = "boolean default false")
	private boolean isActive = false;


	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="work_hour_id")
	private WorkHour workHour;
	
	@ManyToOne
	@JoinColumn(name="work_type_id")
	private WorkType workType;
	
	@OneToOne(mappedBy="jobAdvert")
	@JsonIgnore
	private JobAdvertConfirmation jobAdvertConfirmation;
}
