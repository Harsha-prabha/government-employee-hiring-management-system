

package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class InterviewFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    private String content;
    private boolean isInternal;
    private String interviewRound;

    @ManyToOne
    @JoinColumn(name = "jobApplicationId")
    private JobApplication jobApplication;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public InterviewFeedback() {
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getContent() {
        return content;
    }
 
    public void setContent(String content) {
        this.content = content;
    }
 
    public boolean isInternal() {
        return isInternal;
    }
 
    public void setInternal(boolean internal) {
        isInternal = internal;
    }
 
    public String getInterviewRound() {
        return interviewRound;
    }
 
    public void setInterviewRound(String interviewRound) {
        this.interviewRound = interviewRound;
    }
 
    public JobApplication getJobApplication() {
        return jobApplication;
    }
 
    public void setJobApplication(JobApplication jobApplication) {
        this.jobApplication = jobApplication;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
}

