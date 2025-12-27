
package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    private String coverLetter;
    private String resumeUrl;
    private String status;   // e.g., INTERVIEW
    private String priority; // e.g., HIGH

    @ManyToOne
    //@JoinColumn(name = "candidate_id")
    private User candidate;

    @ManyToOne
    //@JoinColumn(name = "position_id")
    private JobPosition jobPosition;

    public JobApplication() {}

    public JobApplication(Long applicationId, String coverLetter, String resumeUrl,
                          String status, String priority, User candidate, JobPosition jobPosition) {
        this.applicationId = applicationId;
        this.coverLetter = coverLetter;
        this.resumeUrl = resumeUrl;
        this.status = status;
        this.priority = priority;
        this.candidate = candidate;
        this.jobPosition = jobPosition;
    }

    public Long getApplicationId() { return applicationId; }
    public void setApplicationId(Long applicationId) { this.applicationId = applicationId; }

    public String getCoverLetter() { return coverLetter; }
    public void setCoverLetter(String coverLetter) { this.coverLetter = coverLetter; }

    public String getResumeUrl() { return resumeUrl; }
    public void setResumeUrl(String resumeUrl) { this.resumeUrl = resumeUrl; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public User getCandidate() { return candidate; }
    public void setCandidate(User candidate) { this.candidate = candidate; }

    public JobPosition getJobPosition() { return jobPosition; }
    public void setJobPosition(JobPosition jobPosition) { this.jobPosition = jobPosition; }
}


