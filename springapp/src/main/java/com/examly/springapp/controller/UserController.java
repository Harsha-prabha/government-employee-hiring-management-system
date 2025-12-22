package com.examly.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private static List<User> userList = new ArrayList<>();
  private static int userIdCounter = 1;

  // ---------------- ADD USER ----------------
  @PostMapping
  public ResponseEntity<User> addUser(@RequestBody User user) {
    user.setUserId(userIdCounter++);
    userList.add(user);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }

  // ---------------- GET ALL USERS ----------------
  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    return new ResponseEntity<>(userList, HttpStatus.OK);
  }

  // ---------------- GET USER BY ID ----------------
  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable int id) {
    return new ResponseEntity<>(userList.get(id - 1), HttpStatus.OK);
  }

  // ---------------- UPDATE USER ----------------
  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable int id,
      @RequestBody User updatedUser) {

    User existingUser = userList.get(id - 1);

    if (updatedUser.getUsername() != null)
      existingUser.setUsername(updatedUser.getUsername());

    if (updatedUser.getEmail() != null)
      existingUser.setEmail(updatedUser.getEmail());

    if (updatedUser.getRole() != null)
      existingUser.setRole(updatedUser.getRole());

    if (updatedUser.getPhoneNumber() != null)
      existingUser.setPhoneNumber(updatedUser.getPhoneNumber());

    if (updatedUser.getDepartment() != null)
      existingUser.setDepartment(updatedUser.getDepartment());

    return new ResponseEntity<>(existingUser, HttpStatus.OK);
  }
}

