package com.javareact.hrms.entities.concretes;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cv_schools")

public class Education extends Base{
	

    @Column(name = "school_name")
    @NotNull
    @NotBlank
    private String schoolName;

    @Column(name = "department_name")
    @NotNull
    @NotBlank
    private String departmentName;

    @Column(name = "start_year")
    @NotNull
    @NotBlank
    private int startYear;

    @Column(name = "graduation_year",nullable=true)
    private int graduationYear;

    @ManyToOne()
    //@JsonIgnore()
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;
}
