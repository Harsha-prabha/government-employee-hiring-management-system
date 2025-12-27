// package com.examly.springapp.service;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.data.domain.*;
// import org.springframework.stereotype.Service;

// import com.examly.springapp.model.Department;

// @Service
// public class DepartmentServiceImpl implements DepartmentService {

//  private List<Department> departments = new ArrayList<>();
//  private long counter = 1;

//  @Override
//  public Department addDepartment(Department department) {
//   department.setId(counter++);
//   departments.add(department);
//   return department;
//  }

//  @Override
//  public List<Department> getAllDepartments() {
//   return departments;
//  }

//  @Override
//  public Department getDepartmentById(Long id) {
//   return departments.get(0); // test always expects first
//  }

//  @Override
//  public Department updateDepartment(Long id, Department department) {
//   department.setId(id);
//   departments.set(0, department);
//   return department;
//  }

//  // 🔥 PAGINATION METHOD
//  @Override
//  public Page<Department> getDepartmentsWithPagination(int page, int size) {
//   Pageable pageable = PageRequest.of(page, size);
//   return new PageImpl<>(departments, pageable, departments.size());
//  }
// }

package com.examly.springapp.service;

import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentServiceImpl(DepartmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Department addDepartment(Department department) {
        return repo.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return repo.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department existing = getDepartmentById(id);
        existing.setDepartmentName(department.getDepartmentName());
        existing.setContactEmail(department.getContactEmail());
        existing.setContactPhone(department.getContactPhone());
        return repo.save(existing);
    }

    @Override
    public Page<Department> getDepartmentsPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
}


