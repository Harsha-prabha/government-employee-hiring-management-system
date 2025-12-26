package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.service.JobPositionService;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionController {

 @Autowired
 private JobPositionService jobPositionService;

 @PostMapping
 public ResponseEntity<JobPosition> addJobPosition(
   @RequestBody JobPosition jobPosition) {

  return new ResponseEntity<>(
    jobPositionService.addJobPosition(jobPosition),
    HttpStatus.CREATED);
 }

 @GetMapping
 public ResponseEntity<List<JobPosition>> getAllJobPositions() {
  return new ResponseEntity<>(
    jobPositionService.getAllJobPositions(),
    HttpStatus.OK);
 }

 @GetMapping("/{id}")
 public ResponseEntity<JobPosition> getJobPositionById(
   @PathVariable Long id) {

  return new ResponseEntity<>(
    jobPositionService.getJobPositionById(id),
    HttpStatus.OK);
 }

 @PutMapping("/{id}")
 public ResponseEntity<JobPosition> updateJobPosition(
   @PathVariable Long id,
   @RequestBody JobPosition jobPosition) {

  return new ResponseEntity<>(
    jobPositionService.updateJobPosition(id, jobPosition),
    HttpStatus.OK);
 }

 @GetMapping("/search/{keyword}")
 public ResponseEntity<List<JobPosition>> searchJobPositions(
   @PathVariable String keyword) {

  return new ResponseEntity<>(
    jobPositionService.searchJobPositions(keyword),
    HttpStatus.OK);
 }
}



