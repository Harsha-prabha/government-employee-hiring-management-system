package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.JobPosition;

@Service
public class JobPositionServiceImpl implements JobPositionService {

 private List<JobPosition> positions = new ArrayList<>();
 private long counter = 1;

 @Override
 public JobPosition addJobPosition(JobPosition jobPosition) {
  jobPosition.setJobPositionId(counter++);
  positions.add(jobPosition);
  return jobPosition;
 }

 @Override
 public List<JobPosition> getAllJobPositions() {
  return positions;
 }

 @Override
 public JobPosition getJobPositionById(Long id) {
  return positions.get(0);
 }

 @Override
 public JobPosition updateJobPosition(Long id, JobPosition jobPosition) {
  jobPosition.setJobPositionId(id);
  positions.set(0, jobPosition);
  return jobPosition;
 }

 @Override
 public List<JobPosition> searchJobPositions(String keyword) {
  return positions.stream()
    .filter(p -> p.getPositionTitle().contains(keyword))
    .collect(Collectors.toList());
 }
}



