// package com.examly.springapp.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.*;
// import org.springframework.web.bind.annotation.*;

// import com.examly.springapp.model.InterviewFeedback;
// import com.examly.springapp.service.InterviewFeedbackService;

// @RestController
// @RequestMapping("/api/interview-feedbacks")
// public class InterviewFeedbackController {

//  @Autowired
//  private InterviewFeedbackService interviewFeedbackService;

//  @PostMapping
//  public ResponseEntity<InterviewFeedback> addInterviewFeedback(
//    @RequestBody InterviewFeedback feedback) {

//   return new ResponseEntity<>(
//     interviewFeedbackService.addInterviewFeedback(feedback),
//     HttpStatus.CREATED);
//  }

//  @GetMapping
//  public ResponseEntity<List<InterviewFeedback>> getAllInterviewFeedbacks() {
//   return new ResponseEntity<>(
//     interviewFeedbackService.getAllInterviewFeedbacks(),
//     HttpStatus.OK);
//  }

//  @GetMapping("/{id}")
//  public ResponseEntity<InterviewFeedback> getInterviewFeedbackById(
//    @PathVariable Long id) {

//   return new ResponseEntity<>(
//     interviewFeedbackService.getInterviewFeedbackById(id),
//     HttpStatus.OK);
//  }

//  @PutMapping("/{id}")
//  public ResponseEntity<InterviewFeedback> updateInterviewFeedback(
//    @PathVariable Long id,
//    @RequestBody InterviewFeedback feedback) {

//   return new ResponseEntity<>(
//     interviewFeedbackService.updateInterviewFeedback(id, feedback),
//     HttpStatus.OK);
//  }

//  @GetMapping("/application/{applicationId}")
//  public ResponseEntity<List<InterviewFeedback>> getFeedbacksByJobApplication(
//    @PathVariable Long applicationId) {

//   return new ResponseEntity<>(
//     interviewFeedbackService.getFeedbacksByJobApplication(applicationId),
//     HttpStatus.OK);
//  }
// }

package com.examly.springapp.controller;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.service.InterviewFeedbackService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.List;

@RestController
@RequestMapping("/api/interview-feedbacks")
public class InterviewFeedbackController {

    private final InterviewFeedbackService service;

    public InterviewFeedbackController(InterviewFeedbackService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InterviewFeedback> addFeedback(@RequestBody InterviewFeedback feedback) {
        InterviewFeedback created = service.addFeedback(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<InterviewFeedback>> getAllFeedbacks() {
        return ResponseEntity.ok(service.getAllFeedbacks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewFeedback> getFeedbackById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFeedbackById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewFeedback> updateFeedback(@PathVariable Long id,
                                                            @RequestBody InterviewFeedback feedback) {
        return ResponseEntity.ok(service.updateFeedback(id, feedback));
    }

    
    @GetMapping("/application/{id}")
    public ResponseEntity<List<InterviewFeedback>> getFeedbacksByJobApplication(@PathVariable Long id) {
    List<InterviewFeedback> feedbacks = service.getByJobApplicationId(id);
    return ResponseEntity.ok(feedbacks);
    
}


}






