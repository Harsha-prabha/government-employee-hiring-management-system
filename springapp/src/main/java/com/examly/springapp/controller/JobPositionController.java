
package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.repository.JobPositionRepository;
import com.examly.springapp.model.JobPosition;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionController {

 @Autowired
 JobPositionRepository r;

 @PostMapping
 public ResponseEntity<JobPosition> post(@RequestBody JobPosition j){
  try{
   JobPosition ans=r.save(j);
   return ResponseEntity.status(HttpStatus.CREATED).body(ans);
  }
  catch(Exception e){
   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
 }
 @GetMapping
 public ResponseEntity<List<JobPosition>> set2(){
  try{
   List<JobPosition> j=r.findAll();
   return ResponseEntity.status(HttpStatus.OK).body(j); 
  }
  catch(Exception e){
  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
 }



 @GetMapping("/{id}")
 public ResponseEntity<JobPosition> set3(@PathVariable int id){
  try{
   JobPosition j=r.findById(id).get();
   return ResponseEntity.status(HttpStatus.OK).body(j);
  }
  catch(Exception e){
   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
 }
 
 @PutMapping("/{id}")
 public ResponseEntity<JobPosition> set4(@PathVariable int id,@RequestBody JobPosition position){
  try{
   position.setPositionId(id);
   JobPosition j=r.save(position);
   return ResponseEntity.status(HttpStatus.OK).body(j);
  }
  catch(Exception e){
   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
 }

  @GetMapping("/search/{keyword}")
 public ResponseEntity<List<JobPosition>> searchByKeyword(@PathVariable String keyword) {
  try {
   
   List<JobPosition> positions = r.findByPositionTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
   
   if (positions.isEmpty()) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
   }
   return ResponseEntity.status(HttpStatus.OK).body(positions);
  } catch (Exception e) {
   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
 }


}