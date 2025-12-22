package com.examly.springapp.controller;
import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import com.examly.springapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
  

  @Autowired
  DepartmentService departmentService;

  @Autowired
  DepartmentRepository departmentRepository;


  @PostMapping
  public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
    try {
      Department savedDepartment = departmentService.saveDepartment(department);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
  @GetMapping
  public ResponseEntity<List<Department>> getAllDepartments() {
    List<Department> departments = departmentService.getAllDepartments();
    return new ResponseEntity<>(departments, HttpStatus.OK);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
    Department department = departmentService.getDepartmentById(id);
    if (department != null) {
      return new ResponseEntity<>(department, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Department> updateDepartment(
      @PathVariable int id,
      @RequestBody Department department) {
    Department updatedDepartment = departmentService.updateDepartment(id, department);
    if (updatedDepartment != null) {
      return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  @GetMapping("/page/{pageNumber}/{pageSize}")
  public ResponseEntity<Page<Department>> getDepartmentsWithPagination(
      @PathVariable int pageNumber,
      @PathVariable int pageSize) {

    Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("departmentId").ascending());
    Page<Department> page = departmentRepository.findAll(pageable);

    return new ResponseEntity<>(page, HttpStatus.OK);
  }
}


