package com.examly.springapp.service;

import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

 @Autowired
 private DepartmentRepository departmentRepository;

 public Department saveDepartment(Department department) {
  return departmentRepository.save(department);
 }

 public List<Department> getAllDepartments() {
  return departmentRepository.findAll();
 }

 public Department getDepartmentById(int id) {
  return departmentRepository.findById(id).orElse(null);
 }

 public Department updateDepartment(int id, Department departmentDetails) {
  Optional<Department> optionalDepartment = departmentRepository.findById(id);

  if (optionalDepartment.isPresent()) {
   Department existingDepartment = optionalDepartment.get();
   existingDepartment.setDepartmentName(departmentDetails.getDepartmentName());
   existingDepartment.setContactEmail(departmentDetails.getContactEmail());
   existingDepartment.setContactPhone(departmentDetails.getContactPhone());
   return departmentRepository.save(existingDepartment);
  } else {
   return null;
  }
 }
}


