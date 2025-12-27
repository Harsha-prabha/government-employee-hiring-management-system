
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






