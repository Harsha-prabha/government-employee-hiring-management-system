package com.examly.springapp.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jobApplicationId;
    @Column(name="applicationDate")
    private Date applicationDate;
    @Column(name="status")
    private String status;
    public long getJobApplicationId() {
        return jobApplicationId;
    }
    public void setJobApplicationId(long jobApplicationId) {
        this.jobApplicationId = jobApplicationId;
    }
    public Date getApplicationDate() {
        return applicationDate;
    }
    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public JobApplication(Date applicationDate, String status) {
        this.applicationDate = applicationDate;
        this.status = status;
    }

}
