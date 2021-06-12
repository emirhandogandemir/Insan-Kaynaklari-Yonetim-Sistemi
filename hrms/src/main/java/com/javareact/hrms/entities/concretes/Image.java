package com.javareact.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv_images")
public class Image extends Base{
	

    @Column(name = "url")
    @NotNull
    private String url;

    @Column(name = "uploaded_at" , columnDefinition = "Date default CURRENT_DATE")
    private LocalDateTime uploadedAt;

    @OneToOne()
    //@JsonIgnore()
    @JoinColumn(name = "jobseeker_id",referencedColumnName="user_id")
    private JobSeeker jobSeeker;
}
