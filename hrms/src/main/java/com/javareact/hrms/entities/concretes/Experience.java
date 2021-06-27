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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv_experiences")
public class Experience extends Base{
	
	

    @Column(name = "workplace_name")
    @NotNull
    @NotBlank
    private String workplaceName;

    @Column(name = "position")
    @NotNull
    @NotBlank
    private String position;

    @Column(name = "start_date")
    @NotNull
    @Past
    private LocalDate startDate;

    @Column(name = "leave_date")
    private LocalDate leaveDate;

    @ManyToOne()
    //@JsonIgnore()
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;
    
}
