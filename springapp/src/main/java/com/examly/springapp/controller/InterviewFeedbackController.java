package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.service.InterviewFeedbackService;

@RestController
@RequestMapping("/api/interview-feedbacks")
public class InterviewFeedbackController {

 @Autowired
 private InterviewFeedbackService interviewFeedbackService;

 @PostMapping
 public ResponseEntity<InterviewFeedback> addInterviewFeedback(
   @RequestBody InterviewFeedback feedback) {

  return new ResponseEntity<>(
    interviewFeedbackService.addInterviewFeedback(feedback),
    HttpStatus.CREATED);
 }

 @GetMapping
 public ResponseEntity<List<InterviewFeedback>> getAllInterviewFeedbacks() {
  return new ResponseEntity<>(
    interviewFeedbackService.getAllInterviewFeedbacks(),
    HttpStatus.OK);
 }

 @GetMapping("/{id}")
 public ResponseEntity<InterviewFeedback> getInterviewFeedbackById(
   @PathVariable Long id) {

  return new ResponseEntity<>(
    interviewFeedbackService.getInterviewFeedbackById(id),
    HttpStatus.OK);
 }

 @PutMapping("/{id}")
 public ResponseEntity<InterviewFeedback> updateInterviewFeedback(
   @PathVariable Long id,
   @RequestBody InterviewFeedback feedback) {

  return new ResponseEntity<>(
    interviewFeedbackService.updateInterviewFeedback(id, feedback),
    HttpStatus.OK);
 }

 @GetMapping("/application/{applicationId}")
 public ResponseEntity<List<InterviewFeedback>> getFeedbacksByJobApplication(
   @PathVariable Long applicationId) {

  return new ResponseEntity<>(
    interviewFeedbackService.getFeedbacksByJobApplication(applicationId),
    HttpStatus.OK);
 }
}



