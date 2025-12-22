package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class User {

  @Id
  private int userId;

  private String username;
  private String email;
  private String password;
  private String role;
  private String phoneNumber;
  @ManyToOne
  private Department department;

  public User() {
  }

  // Getters and Setters

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }
 
  public void setUsername(String username) {
    this.username = username;
  }
 
  public String getEmail() {
    return email;
  }
 
  public void setEmail(String email) {
    this.email = email;
  }
 
  public String getPassword() {
    return password;
  }
 
  public void setPassword(String password) {
    this.password = password;
  }
 
  public String getRole() {
    return role;
  }
 
  public void setRole(String role) {
    this.role = role;
  }
 
  public String getPhoneNumber() {
    return phoneNumber;
  }
 
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
 
  public Department getDepartment() {
    return department;
  }
 
  public void setDepartment(Department department) {
    this.department = department;
  }
}

