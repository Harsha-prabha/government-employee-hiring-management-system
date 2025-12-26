package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.InterviewFeedback;

@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {

 private final List<InterviewFeedback> feedbackList = new ArrayList<>();
 private long idCounter = 1;

 @Override
 public InterviewFeedback addInterviewFeedback(InterviewFeedback feedback) {
  feedback.setFeedbackId(idCounter++);
  feedbackList.add(feedback);
  return feedback;
 }

 @Override
 public List<InterviewFeedback> getAllInterviewFeedbacks() {
  return feedbackList;
 }

 @Override
 public InterviewFeedback getInterviewFeedbackById(Long id) {
  return feedbackList.stream()
    .filter(f -> f.getFeedbackId().equals(id))
    .findFirst()
    .orElse(null);
 }

 @Override
 public InterviewFeedback updateInterviewFeedback(Long id, InterviewFeedback feedback) {
  InterviewFeedback existing = getInterviewFeedbackById(id);
  if (existing != null) {
   existing.setContent(feedback.getContent());
   existing.setIsInternal(feedback.getIsInternal());
   existing.setInterviewRound(feedback.getInterviewRound());
  }
  return existing;
 }

 @Override
 public List<InterviewFeedback> getFeedbacksByJobApplication(Long applicationId) {
  return feedbackList;
 }
}



