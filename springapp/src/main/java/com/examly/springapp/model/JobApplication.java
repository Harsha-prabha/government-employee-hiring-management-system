
package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    private String coverLetter;
    private String resumeUrl;
    private String status;
    private String priority;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "jobPositionId")
    private JobPosition jobPosition;

    public JobApplication() {
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public String getPriority() {
        return priority;
    }
 
    public void setPriority(String priority) {
        this.priority = priority;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    public JobPosition getJobPosition() {
        return jobPosition;
    }
 
    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }
}

