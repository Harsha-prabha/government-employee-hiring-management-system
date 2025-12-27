// package com.examly.springapp.model;

// import jakarta.persistence.*;

// @Entity
// public class JobPosition {

//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private Long jobPositionId;

//  private String positionTitle;
//  private String description;
//  private String location;
//  private String experienceRequired;
//  private int openings;

//  @ManyToOne
//  private Department department;

//  public JobPosition() {}

//  public Long getJobPositionId() { return jobPositionId; }
//  public void setJobPositionId(Long jobPositionId) {
//   this.jobPositionId = jobPositionId;
//  }

//  public String getPositionTitle() { return positionTitle; }
//  public void setPositionTitle(String positionTitle) {
//   this.positionTitle = positionTitle;
//  }

//  public String getDescription() { return description; }
//  public void setDescription(String description) {
//   this.description = description;
//  }

//  public String getLocation() { return location; }
//  public void setLocation(String location) {
//   this.location = location;
//  }

//  public String getExperienceRequired() { return experienceRequired; }
//  public void setExperienceRequired(String experienceRequired) {
//   this.experienceRequired = experienceRequired;
//  }

//  public int getOpenings() { return openings; }
//  public void setOpenings(int openings) { this.openings = openings; }

//  public Department getDepartment() { return department; }
//  public void setDepartment(Department department) {
//   this.department = department;
//  }
// }

package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;

    private String positionTitle;
    private String description;
    private String location;
    private String experienceRequired;
    private Integer openings;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public JobPosition() {}

    public JobPosition(Long positionId, String positionTitle, String description, String location,
                       String experienceRequired, Integer openings, Department department) {
        this.positionId = positionId;
        this.positionTitle = positionTitle;
        this.description = description;
        this.location = location;
        this.experienceRequired = experienceRequired;
        this.openings = openings;
        this.department = department;
    }

    public Long getPositionId() { return positionId; }
    public void setPositionId(Long positionId) { this.positionId = positionId; }

    public String getPositionTitle() { return positionTitle; }
    public void setPositionTitle(String positionTitle) { this.positionTitle = positionTitle; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getExperienceRequired() { return experienceRequired; }
    public void setExperienceRequired(String experienceRequired) { this.experienceRequired = experienceRequired; }

    public Integer getOpenings() { return openings; }
    public void setOpenings(Integer openings) { this.openings = openings; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}


