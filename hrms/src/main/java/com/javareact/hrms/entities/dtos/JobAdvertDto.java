package com.javareact.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {

	private int jobPositionId;
	
	private int employerId;
	
	private String description;
	
	private int cityId;
	
	private int minSalary;
	
	private int maxSalary;
	
	private int openPositionCount;
	
	private LocalDateTime deadLine;
	
	private LocalDateTime publishedAt;
	
	private boolean isActive;
	
	
	private int workType;
	
	private int workTime;
	
}
