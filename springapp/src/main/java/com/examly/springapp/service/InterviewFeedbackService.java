// package com.examly.springapp.service;

// import java.util.List;
// import com.examly.springapp.model.InterviewFeedback;

// public interface InterviewFeedbackService {

//  InterviewFeedback addInterviewFeedback(InterviewFeedback feedback);

//  List<InterviewFeedback> getAllInterviewFeedbacks();

//  InterviewFeedback getInterviewFeedbackById(Long id);

//  InterviewFeedback updateInterviewFeedback(Long id, InterviewFeedback feedback);

//  List<InterviewFeedback> getFeedbacksByJobApplication(Long applicationId);
// }


package com.examly.springapp.service;

import com.examly.springapp.model.InterviewFeedback;
import java.util.List;

public interface InterviewFeedbackService {
    InterviewFeedback addFeedback(InterviewFeedback feedback);
    List<InterviewFeedback> getAllFeedbacks();
    InterviewFeedback getFeedbackById(Long id);
    InterviewFeedback updateFeedback(Long id, InterviewFeedback feedback);
    List<InterviewFeedback> getByJobApplicationId(Long applicationId);

}

