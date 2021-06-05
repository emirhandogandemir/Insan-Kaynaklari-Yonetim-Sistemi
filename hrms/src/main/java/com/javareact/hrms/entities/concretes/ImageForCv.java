package com.javareact.hrms.entities.concretes;

import java.time.LocalDate;

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



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv_images")
public class ImageForCv extends Base{
	

    @Column(name = "url")
    private String url;

    @Column(name = "uploaded_at" , columnDefinition = "Date default CURRENT_DATE")
    private LocalDate uploadedAt;

    @OneToOne(optional=false,fetch=FetchType.LAZY)
    //@JsonIgnore()
    @JoinColumn(name = "jobseeker_id",referencedColumnName="user_id")
    private JobSeeker jobSeeker;
}
