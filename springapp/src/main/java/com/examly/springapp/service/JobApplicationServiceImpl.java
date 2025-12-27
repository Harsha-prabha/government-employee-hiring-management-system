
package com.examly.springapp.service;

import com.examly.springapp.model.JobApplication;
import com.examly.springapp.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository repo;

    public JobApplicationServiceImpl(JobApplicationRepository repo) {
        this.repo = repo;
    }

    @Override
    public JobApplication addJobApplication(JobApplication jobApplication) {
        return repo.save(jobApplication);
    }

    @Override
    public List<JobApplication> getAllJobApplications() {
        return repo.findAll();
    }

    @Override
    public JobApplication getJobApplicationById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Job application not found"));
    }

    @Override
    public JobApplication updateJobApplication(Long id, JobApplication jobApplication) {
        JobApplication existing = getJobApplicationById(id);
        existing.setCoverLetter(jobApplication.getCoverLetter());
        existing.setResumeUrl(jobApplication.getResumeUrl());
        existing.setStatus(jobApplication.getStatus());
        existing.setPriority(jobApplication.getPriority());
        existing.setCandidate(jobApplication.getCandidate());
        existing.setJobPosition(jobApplication.getJobPosition());
        return repo.save(existing);
    }

    @Override
    public void deleteJobApplication(Long id) {
        JobApplication existing = getJobApplicationById(id);
        repo.delete(existing);
    }
}
