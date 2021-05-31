package com.javareact.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	


	
	

}
