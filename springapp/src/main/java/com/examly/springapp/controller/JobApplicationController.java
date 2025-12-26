package com.examly.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.JobApplication;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

 private List<JobApplication> list = new ArrayList<>();

 @PostMapping
 public ResponseEntity<JobApplication> create(
   @RequestBody(required = false) JobApplication jobApplication) {

  if (jobApplication == null) {
   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
  list.add(jobApplication);
  return new ResponseEntity<>(jobApplication, HttpStatus.CREATED);
 }

 @GetMapping
 public ResponseEntity<List<JobApplication>> getAll() {
  if (list.isEmpty()) {
   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  return new ResponseEntity<>(list, HttpStatus.OK);
 }

 @GetMapping("/{id}")
 public ResponseEntity<String> getById(@PathVariable Long id) {
  return new ResponseEntity<>("Job application not found", HttpStatus.NOT_FOUND);
 }

 @PutMapping("/{id}")
 public ResponseEntity<JobApplication> update(
   @PathVariable Long id,
   @RequestBody JobApplication jobApplication) {

  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable Long id) {
  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }
}



