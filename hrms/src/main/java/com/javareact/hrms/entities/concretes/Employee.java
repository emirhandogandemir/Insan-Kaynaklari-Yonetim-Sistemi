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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javareact.hrms.core.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@Entity
@Table(name="employees")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertConfirmations"})
public class Employee extends User{

	
	
	
	@Column(name = "first_name")
	@NotNull(message="firstname cannot be null")
	@NotBlank
	@Size(min=3,max=30,message="About Me must be between 3 and 30 characters")
	private String firstName;
	
	@Column(name = "last_name")
	@NotNull(message="lastName cannot be null")
	@NotBlank
	@Size(min=3,max=30,message="About Me must be between 3 and 30 characters")
	private String lastName;
	

	@OneToMany(mappedBy="employee")
	@JsonIgnore
	private List<JobAdvertConfirmation> jobAdvertConfirmations;
	
	

}
