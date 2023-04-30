package com.JobSearchPortal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    private String location;
    private Double salary;
    private String companyName;
    private String employerName;
    @Enumerated(EnumType.STRING)
    private JobType jobType;

}
