// package com.examly.springapp.service;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.stereotype.Service;

// import com.examly.springapp.model.JobPosition;

// @Service
// public class JobPositionServiceImpl implements JobPositionService {

//  private List<JobPosition> positions = new ArrayList<>();
//  private long counter = 1;

//  @Override
//  public JobPosition addJobPosition(JobPosition jobPosition) {
//   jobPosition.setJobPositionId(counter++);
//   positions.add(jobPosition);
//   return jobPosition;
//  }

//  @Override
//  public List<JobPosition> getAllJobPositions() {
//   return positions;
//  }

//  @Override
//  public JobPosition getJobPositionById(Long id) {
//   return positions.get(0);
//  }

//  @Override
//  public JobPosition updateJobPosition(Long id, JobPosition jobPosition) {
//   jobPosition.setJobPositionId(id);
//   positions.set(0, jobPosition);
//   return jobPosition;
//  }

//  @Override
//  public List<JobPosition> searchJobPositions(String keyword) {
//   return positions.stream()
//     .filter(p -> p.getPositionTitle().contains(keyword))
//     .collect(Collectors.toList());
//  }
// }

package com.examly.springapp.service;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.repository.JobPositionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPositionServiceImpl implements JobPositionService {

    private final JobPositionRepository repo;

    public JobPositionServiceImpl(JobPositionRepository repo) {
        this.repo = repo;
    }

    @Override
    public JobPosition addJobPosition(JobPosition jobPosition) {
        return repo.save(jobPosition);
    }

    @Override
    public List<JobPosition> getAllJobPositions() {
        return repo.findAll();
    }

    @Override
    public JobPosition getJobPositionById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Job position not found"));
    }

    @Override
    public JobPosition updateJobPosition(Long id, JobPosition jobPosition) {
        JobPosition existing = getJobPositionById(id);
        existing.setPositionTitle(jobPosition.getPositionTitle());
        existing.setDescription(jobPosition.getDescription());
        existing.setLocation(jobPosition.getLocation());
        existing.setExperienceRequired(jobPosition.getExperienceRequired());
        existing.setOpenings(jobPosition.getOpenings());
        existing.setDepartment(jobPosition.getDepartment());
        return repo.save(existing);
    }

    @Override
    public List<JobPosition> searchByKeyword(String keyword) {
        List<JobPosition> byTitle = repo.findByPositionTitleContainingIgnoreCase(keyword);
        List<JobPosition> byDesc = repo.findByDescriptionContainingIgnoreCase(keyword);
        List<JobPosition> result = new ArrayList<>(byTitle);
        for (JobPosition jp : byDesc) {
            if (!result.contains(jp)) {
                result.add(jp);
            }
        }
        return result;
    }
}



