package com.javareact.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javareact.hrms.core.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "employers")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User{

	
	@Column(name= "company_name")
	@NotNull(message="CompanyName cannot be null")
	@NotBlank
	private String companyName;
	
	@Column(name= "website")
	@NotNull(message="website cannot be null")
	@NotBlank
	private String website;
	
	@Column(name= "phone_number")
	@NotNull(message="website cannot be null")
	@NotBlank
	private String phoneNumber;
	
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;
	
	@JsonIgnore// bunu swaggerda görmemin bir mantığı yok
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
	
}
