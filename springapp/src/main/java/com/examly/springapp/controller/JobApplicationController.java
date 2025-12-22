package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.JobApplication;
import com.examly.springapp.repository.JobApplicationRepository;

@RequestMapping
@RestController
public class JobApplicationController {
 @Autowired
 JobApplicationRepository j;
 

 @PostMapping("/api/job-applications")
 public JobApplication posting(@RequestBody JobApplication obj){
  j.save(obj);
  return obj;
 }
 @GetMapping("/api/job-applications")
 public ResponseEntity<List<JobApplication>> getting() {
 List<JobApplication> o = j.findAll();
 if (o.isEmpty()) {
  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }
 return new ResponseEntity<>(o, HttpStatus.OK);
 }
 @GetMapping("/api/job-applications/{id}")
 public ResponseEntity<JobApplication> gettingById(@PathVariable int id) {
 return j.findById(id)
   .map(application -> new ResponseEntity<>(application, HttpStatus.OK))
   .orElseGet(() -> new ResponseEntity("Job application not found", HttpStatus.NOT_FOUND));
 }


 @PutMapping("/api/job-applications")
 public String putting(){
  return " ";
 }
 @DeleteMapping("/api/job-applications")
 public String deleting(){
  return " ";
 }
}

