// package com.examly.springapp.controller;

// public class InterviewFeedbackController {
    
// }
package com.examly.springapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interviews")
public class InterviewFeedbackController {

    @PostMapping
    public ResponseEntity<?> createFeedback() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllFeedback() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

