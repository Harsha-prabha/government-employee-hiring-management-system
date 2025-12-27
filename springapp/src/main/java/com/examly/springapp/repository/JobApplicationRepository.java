// package com.examly.springapp.repository;

// import org.springframework.stereotype.Repository;

// @Repository
// public class JobApplicationRepository {
// }


package com.examly.springapp.repository;

import com.examly.springapp.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}

