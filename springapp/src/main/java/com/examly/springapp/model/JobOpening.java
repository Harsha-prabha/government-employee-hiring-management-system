// package com.examly.springapp.model;

// import jakarta.persistence.*;

// @Entity
// public class JobOpening {
//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     private long jobOpeningId;
//     @Column(name="jobTitle")
//     private String jobTitle;
//     @Column(name="jobDescription")
//     private String jobDescription;
//     @Column(name="jobLocation")
//     private String jobLocation;
//     @Column(name="jobType")
//     private String jobType;
//     @Column(name="salary")
//     private double salary;

//     public long getJobOpeningId() {
//         return jobOpeningId;
//     }
//     public void setJobOpeningId(long jobOpeningId) {
//         this.jobOpeningId = jobOpeningId;
//     }
//     public String getJobTitle() {
//         return jobTitle;
//     }
//     public void setJobTitle(String jobTitle) {
//         this.jobTitle = jobTitle;
//     }
//     public String getJobDescription() {
//         return jobDescription;
//     }
//     public void setJobDescription(String jobDescription) {
//         this.jobDescription = jobDescription;
//     }
//     public String getJobLocation() {
//         return jobLocation;
//     }
//     public void setJobLocation(String jobLocation) {
//         this.jobLocation = jobLocation;
//     }
//     public String getJobType() {
//         return jobType;
//     }
//     public void setJobType(String jobType) {
//         this.jobType = jobType;
//     }
//     public double getSalary() {
//         return salary;
//     }
//     public void setSalary(double salary) {
//         this.salary = salary;
//     }

// }
