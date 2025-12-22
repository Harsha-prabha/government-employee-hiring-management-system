package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Department {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int departmentId;
 private String departmentName;
 private String contactEmail;
 private String contactPhone;
 
 
 public int getDepartmentId() {
 return departmentId;
 }
 public Department() {
 }
 
 
 
 public Department(String departmentName, String contactEmail, String contactPhone) {
 this.departmentName = departmentName;
 this.contactEmail = contactEmail;
 this.contactPhone = contactPhone;
 }
 public void setDepartmentId(int departmentId) {
 this.departmentId = departmentId;
 }
 public String getDepartmentName() {
 return departmentName;
 }
 public void setDepartmentName(String departmentName) {
 this.departmentName = departmentName;
 }
 public String getContactEmail() {
 return contactEmail;
 }
 public void setContactEmail(String contactEmail) {
 this.contactEmail = contactEmail;
 }
 public String getContactPhone() {
 return contactPhone;
 }
 public void setContactPhone(String contactPhone) {
 this.contactPhone = contactPhone;
 }
 
}
