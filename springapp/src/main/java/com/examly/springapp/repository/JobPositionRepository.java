
package com.examly.springapp.repository;

import com.examly.springapp.model.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition, Long> {
    List<JobPosition> findByPositionTitleContainingIgnoreCase(String keyword);
    List<JobPosition> findByDescriptionContainingIgnoreCase(String keyword);
}

