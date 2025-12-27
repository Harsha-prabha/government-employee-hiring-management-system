// package com.examly.springapp.model;

// import jakarta.persistence.*;

// @Entity
// public class InterviewFeedback {

//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private Long feedbackId;

//  private String content;

//  // ⚠️ VERY IMPORTANT
//  private Boolean isInternal;

//  private String interviewRound;

//  @ManyToOne
//  private JobApplication jobApplication;

//  @ManyToOne
//  private User user;

//  public InterviewFeedback() {}

//  public Long getFeedbackId() {
//   return feedbackId;
//  }

//  public void setFeedbackId(Long feedbackId) {
//   this.feedbackId = feedbackId;
//  }

//  public String getContent() {
//   return content;
//  }

//  public void setContent(String content) {
//   this.content = content;
//  }

//  // ✅ REQUIRED BY JSONPATH $.isInternal
//  public Boolean getIsInternal() {
//   return isInternal;
//  }

//  public void setIsInternal(Boolean isInternal) {
//   this.isInternal = isInternal;
//  }

//  public String getInterviewRound() {
//   return interviewRound;
//  }

//  public void setInterviewRound(String interviewRound) {
//   this.interviewRound = interviewRound;
//  }

//  public JobApplication getJobApplication() {
//   return jobApplication;
//  }

//  public void setJobApplication(JobApplication jobApplication) {
//   this.jobApplication = jobApplication;
//  }

//  public User getUser() {
//   return user;
//  }

//  public void setUser(User user) {
//   this.user = user;
//  }
// }


package com.examly.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"jobApplication","user"})
public class InterviewFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    private String content;
    private Boolean isInternal;
    private String interviewRound;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private JobApplication jobApplication;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public InterviewFeedback() {}

    public InterviewFeedback(Long feedbackId, String content, Boolean isInternal,
                             String interviewRound, JobApplication jobApplication, User user) {
        this.feedbackId = feedbackId;
        this.content = content;
        this.isInternal = isInternal;
        this.interviewRound = interviewRound;
        this.jobApplication = jobApplication;
        this.user = user;
    }

    public Long getFeedbackId() { return feedbackId; }
    public void setFeedbackId(Long feedbackId) { this.feedbackId = feedbackId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Boolean getIsInternal() { return isInternal; }
    public void setIsInternal(Boolean isInternal) { this.isInternal = isInternal; }

    public String getInterviewRound() { return interviewRound; }
    public void setInterviewRound(String interviewRound) { this.interviewRound = interviewRound; }

    public JobApplication getJobApplication() { return jobApplication; }
    public void setJobApplication(JobApplication jobApplication) { this.jobApplication = jobApplication; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

