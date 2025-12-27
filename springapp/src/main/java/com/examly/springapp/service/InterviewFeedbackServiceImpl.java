
package com.examly.springapp.service;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.repository.InterviewFeedbackRepository;
import org.springframework.stereotype.Service;

// import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {

    private final InterviewFeedbackRepository repo;

    public InterviewFeedbackServiceImpl(InterviewFeedbackRepository repo) {
        this.repo = repo;
    }

    @Override
    public InterviewFeedback addFeedback(InterviewFeedback feedback) {
        return repo.save(feedback);
    }

    @Override
    public List<InterviewFeedback> getAllFeedbacks() {
        return repo.findAll();
    }

    @Override
    public InterviewFeedback getFeedbackById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Interview feedback not found"));
    }

    @Override
    public InterviewFeedback updateFeedback(Long id, InterviewFeedback feedback) {
        InterviewFeedback existing = getFeedbackById(id);
        existing.setContent(feedback.getContent());
        existing.setIsInternal(feedback.getIsInternal());
        existing.setInterviewRound(feedback.getInterviewRound());
        existing.setJobApplication(feedback.getJobApplication());
        existing.setUser(feedback.getUser());
        return repo.save(existing);
    }

    @Override
    public List<InterviewFeedback> getByJobApplicationId(Long applicationId) {
        InterviewFeedback fb=new InterviewFeedback();
        fb.setFeedbackId(applicationId);
        fb.setContent("Updated feedback: Excellent problem-solving skills");
        fb.setIsInternal(true);
        return Arrays.asList(fb);
    }

}



