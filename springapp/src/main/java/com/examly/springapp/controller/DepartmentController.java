package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Department;
import com.examly.springapp.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

 @Autowired
 private DepartmentService departmentService;

 // Day 8 – Add
 @PostMapping
 public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
  return new ResponseEntity<>(
    departmentService.addDepartment(department),
    HttpStatus.CREATED);
 }

 // Day 8 – Get all
 @GetMapping
 public ResponseEntity<List<Department>> getAllDepartments() {
  return new ResponseEntity<>(
    departmentService.getAllDepartments(),
    HttpStatus.OK);
 }

 // Day 8 – Get by ID
 @GetMapping("/{id}")
 public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
  return new ResponseEntity<>(
    departmentService.getDepartmentById(id),
    HttpStatus.OK);
 }

 // Day 8 – Update
 @PutMapping("/{id}")
 public ResponseEntity<Department> updateDepartment(
   @PathVariable Long id,
   @RequestBody Department department) {

  return new ResponseEntity<>(
    departmentService.updateDepartment(id, department),
    HttpStatus.OK);
 }

 // 🔥 Day 9 – Pagination
 @GetMapping("/page/{page}/{size}")
 public ResponseEntity<Page<Department>> getDepartmentsWithPagination(
   @PathVariable int page,
   @PathVariable int size) {

  return new ResponseEntity<>(
    departmentService.getDepartmentsWithPagination(page, size),
    HttpStatus.OK);
 }
}



