// package com.examly.springapp.controller;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.examly.springapp.model.JobApplication;

// @RestController
// @RequestMapping("/api/job-applications")
// public class JobApplicationController {

//  private List<JobApplication> list = new ArrayList<>();

//  @PostMapping
//  public ResponseEntity<JobApplication> create(
//    @RequestBody(required = false) JobApplication jobApplication) {

//   if (jobApplication == null) {
//    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//   }
//   list.add(jobApplication);
//   return new ResponseEntity<>(jobApplication, HttpStatus.CREATED);
//  }

//  @GetMapping
//  public ResponseEntity<List<JobApplication>> getAll() {
//   if (list.isEmpty()) {
//    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//   }
//   return new ResponseEntity<>(list, HttpStatus.OK);
//  }

//  @GetMapping("/{id}")
//  public ResponseEntity<String> getById(@PathVariable Long id) {
//   return new ResponseEntity<>("Job application not found", HttpStatus.NOT_FOUND);
//  }

//  @PutMapping("/{id}")
//  public ResponseEntity<JobApplication> update(
//    @PathVariable Long id,
//    @RequestBody JobApplication jobApplication) {

//   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//  }

//  @DeleteMapping("/{id}")
//  public ResponseEntity<Void> delete(@PathVariable Long id) {
//   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//  }
// }

package com.examly.springapp.controller;

import com.examly.springapp.model.JobApplication;
import com.examly.springapp.service.JobApplicationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JobApplication> addJobApplication(@RequestBody JobApplication jobApplication) {
        if (jobApplication == null) {
            return ResponseEntity.badRequest().build();
        }
        JobApplication created = service.addJobApplication(jobApplication);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<?> getAllJobApplications() {
        List<JobApplication> list = service.getAllJobApplications();
        if (list == null || list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getJobApplicationById(@PathVariable Long id) {
    try {
        JobApplication ja = service.getJobApplicationById(id);
        return ResponseEntity.ok(ja);
    } catch (RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job application not found");
    }
}


    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> updateJobApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication) {
        JobApplication updated = service.updateJobApplication(id, jobApplication);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {
        service.deleteJobApplication(id);
        return ResponseEntity.noContent().build();
    }
}


