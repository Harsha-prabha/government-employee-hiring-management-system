

package com.examly.springapp.controller;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.service.JobPositionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionController {

    private final JobPositionService service;

    public JobPositionController(JobPositionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JobPosition> addJobPosition(@RequestBody JobPosition jobPosition) {
        JobPosition created = service.addJobPosition(jobPosition);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<JobPosition>> getAllJobPositions() {
        return ResponseEntity.ok(service.getAllJobPositions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosition> getJobPositionById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getJobPositionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosition> updateJobPosition(@PathVariable Long id, @RequestBody JobPosition jobPosition) {
        return ResponseEntity.ok(service.updateJobPosition(id, jobPosition));
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<JobPosition>> searchJobPositions(@PathVariable String keyword) {
        return ResponseEntity.ok(service.searchByKeyword(keyword));
    }
}

