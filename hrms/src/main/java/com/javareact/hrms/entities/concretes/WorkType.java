package com.javareact.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="work_types")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class WorkType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="work_type")
	@NotBlank
	@NotNull
	private String workType;
	
	@OneToMany(mappedBy="workType")
	@JsonIgnore
	private List<JobAdvert> jobAdverts;
	
}
