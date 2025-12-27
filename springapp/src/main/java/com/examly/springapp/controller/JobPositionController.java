// package com.examly.springapp.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.*;
// import org.springframework.web.bind.annotation.*;

// import com.examly.springapp.model.JobPosition;
// import com.examly.springapp.service.JobPositionService;

// @RestController
// @RequestMapping("/api/job-positions")
// public class JobPositionController {

//  @Autowired
//  private JobPositionService jobPositionService;

//  @PostMapping
//  public ResponseEntity<JobPosition> addJobPosition(
//    @RequestBody JobPosition jobPosition) {

//   return new ResponseEntity<>(
//     jobPositionService.addJobPosition(jobPosition),
//     HttpStatus.CREATED);
//  }

//  @GetMapping
//  public ResponseEntity<List<JobPosition>> getAllJobPositions() {
//   return new ResponseEntity<>(
//     jobPositionService.getAllJobPositions(),
//     HttpStatus.OK);
//  }

//  @GetMapping("/{id}")
//  public ResponseEntity<JobPosition> getJobPositionById(
//    @PathVariable Long id) {

//   return new ResponseEntity<>(
//     jobPositionService.getJobPositionById(id),
//     HttpStatus.OK);
//  }

//  @PutMapping("/{id}")
//  public ResponseEntity<JobPosition> updateJobPosition(
//    @PathVariable Long id,
//    @RequestBody JobPosition jobPosition) {

//   return new ResponseEntity<>(
//     jobPositionService.updateJobPosition(id, jobPosition),
//     HttpStatus.OK);
//  }

//  @GetMapping("/search/{keyword}")
//  public ResponseEntity<List<JobPosition>> searchJobPositions(
//    @PathVariable String keyword) {

//   return new ResponseEntity<>(
//     jobPositionService.searchJobPositions(keyword),
//     HttpStatus.OK);
//  }
// }


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

