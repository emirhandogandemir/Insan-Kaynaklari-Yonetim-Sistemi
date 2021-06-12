package com.javareact.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

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
    private String schoolName;

    @Column(name = "department_name")
    @NotNull

    private String departmentName;

    @Column(name = "start_year")
    @Min(1950)
    private int startYear;

    @Column(name = "graduation_year",nullable=true)
    @Min(1950)
    private int graduationYear;

    @ManyToOne()
    //@JsonIgnore()
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;
}
