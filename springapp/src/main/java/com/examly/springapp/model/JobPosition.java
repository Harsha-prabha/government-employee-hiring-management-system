

package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobPosition {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int positionId;
 private String positionTitle;
 private String description;
 private String location;
 private int openings;

 @ManyToOne
 @JoinColumn(name = "departmentId")
 private Department department;

 public int getPositionId() {
  return positionId;
 }

 public void setPositionId(int positionId) {
  this.positionId = positionId;
 }

 public String getPositionTitle() {
  return positionTitle;
 }

 public void setPositionTitle(String positionTitle) {
  this.positionTitle = positionTitle;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public String getLocation() {
  return location;
 }

 public void setLocation(String location) {
  this.location = location;
 }

 public int getOpenings() {
  return openings;
 }

 public void setOpenings(int openings) {
  this.openings = openings;
 }

 public Department getDepartment() {
  return department;
 }

 public void setDepartment(Department department) {
  this.department = department;
 }

 public JobPosition(int positionId, String positionTitle, String description, String location, int openings,
   Department department) {
  this.positionId = positionId;
  this.positionTitle = positionTitle;
  this.description = description;
  this.location = location;
  this.openings = openings;
  this.department = department;
 }

 public JobPosition() {
 }

 
}
