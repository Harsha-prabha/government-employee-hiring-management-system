// package com.examly.springapp.service;

// import java.util.List;

// import org.springframework.data.domain.Page;

// import com.examly.springapp.model.Department;

// public interface DepartmentService {

//  Department addDepartment(Department department);

//  List<Department> getAllDepartments();

//  Department getDepartmentById(Long id);

//  Department updateDepartment(Long id, Department department);

//  Page<Department> getDepartmentsWithPagination(int page, int size);
// }


package com.examly.springapp.service;

import com.examly.springapp.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department updateDepartment(Long id, Department department);
    Page<Department> getDepartmentsPage(Pageable pageable);
}

