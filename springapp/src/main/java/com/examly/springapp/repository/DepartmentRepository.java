// package com.examly.springapp.repository;

// import org.springframework.stereotype.Repository;

// @Repository
// public class DepartmentRepository {
// }



package com.examly.springapp.repository;

import com.examly.springapp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
