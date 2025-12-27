// package com.examly.springapp.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Department {

//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private Long id;

//  private String departmentName;
//  private String contactEmail;
//  private String contactPhone;

//  public Department() {}

//  public Long getId() { return id; }
//  public void setId(Long id) { this.id = id; }

//  public String getDepartmentName() { return departmentName; }
//  public void setDepartmentName(String departmentName) {
//   this.departmentName = departmentName;
//  }

//  public String getContactEmail() { return contactEmail; }
//  public void setContactEmail(String contactEmail) {
//   this.contactEmail = contactEmail;
//  }

//  public String getContactPhone() { return contactPhone; }
//  public void setContactPhone(String contactPhone) {
//   this.contactPhone = contactPhone;
//  }
// }

package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String departmentName;
    private String contactEmail;
    private String contactPhone;

    public Department() {}

    public Department(Long departmentId, String departmentName, String contactEmail, String contactPhone) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
}


