// package com.examly.springapp.service;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.examly.springapp.model.InterviewFeedback;

// @Service
// public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {

//  private final List<InterviewFeedback> feedbackList = new ArrayList<>();
//  private long idCounter = 1;

//  @Override
//  public InterviewFeedback addInterviewFeedback(InterviewFeedback feedback) {
//   feedback.setFeedbackId(idCounter++);
//   feedbackList.add(feedback);
//   return feedback;
//  }

//  @Override
//  public List<InterviewFeedback> getAllInterviewFeedbacks() {
//   return feedbackList;
//  }

//  @Override
//  public InterviewFeedback getInterviewFeedbackById(Long id) {
//   return feedbackList.stream()
//     .filter(f -> f.getFeedbackId().equals(id))
//     .findFirst()
//     .orElse(null);
//  }

//  @Override
//  public InterviewFeedback updateInterviewFeedback(Long id, InterviewFeedback feedback) {
//   InterviewFeedback existing = getInterviewFeedbackById(id);
//   if (existing != null) {
//    existing.setContent(feedback.getContent());
//    existing.setIsInternal(feedback.getIsInternal());
//    existing.setInterviewRound(feedback.getInterviewRound());
//   }
//   return existing;
//  }

//  @Override
//  public List<InterviewFeedback> getFeedbacksByJobApplication(Long applicationId) {
//   return feedbackList;
//  }
// }

package com.examly.springapp.service;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.repository.InterviewFeedbackRepository;
import org.springframework.stereotype.Service;

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
        return repo.findByJobApplication_ApplicationId(applicationId);
    }

}



