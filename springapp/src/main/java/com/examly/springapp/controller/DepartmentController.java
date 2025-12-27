// package com.examly.springapp.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.http.*;
// import org.springframework.web.bind.annotation.*;

// import com.examly.springapp.model.Department;
// import com.examly.springapp.service.DepartmentService;

// @RestController
// @RequestMapping("/api/departments")
// public class DepartmentController {

//  @Autowired
//  private DepartmentService departmentService;

//  // Day 8 – Add
//  @PostMapping
//  public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
//   return new ResponseEntity<>(
//     departmentService.addDepartment(department),
//     HttpStatus.CREATED);
//  }

//  // Day 8 – Get all
//  @GetMapping
//  public ResponseEntity<List<Department>> getAllDepartments() {
//   return new ResponseEntity<>(
//     departmentService.getAllDepartments(),
//     HttpStatus.OK);
//  }

//  // Day 8 – Get by ID
//  @GetMapping("/{id}")
//  public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
//   return new ResponseEntity<>(
//     departmentService.getDepartmentById(id),
//     HttpStatus.OK);
//  }

//  // Day 8 – Update
//  @PutMapping("/{id}")
//  public ResponseEntity<Department> updateDepartment(
//    @PathVariable Long id,
//    @RequestBody Department department) {

//   return new ResponseEntity<>(
//     departmentService.updateDepartment(id, department),
//     HttpStatus.OK);
//  }

//  // 🔥 Day 9 – Pagination
//  @GetMapping("/page/{page}/{size}")
//  public ResponseEntity<Page<Department>> getDepartmentsWithPagination(
//    @PathVariable int page,
//    @PathVariable int size) {

//   return new ResponseEntity<>(
//     departmentService.getDepartmentsWithPagination(page, size),
//     HttpStatus.OK);
//  }
// }



package com.examly.springapp.controller;

import com.examly.springapp.model.Department;
import com.examly.springapp.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department created = service.addDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> list = service.getAllDepartments();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department d = service.getDepartmentById(id);
        return ResponseEntity.ok(d);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        Department updated = service.updateDepartment(id, department);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<Department>> getDepartmentsPage(@PathVariable int page, @PathVariable int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Department> pageResult = service.getDepartmentsPage(pageable);
        return ResponseEntity.ok(pageResult);
    }
}
