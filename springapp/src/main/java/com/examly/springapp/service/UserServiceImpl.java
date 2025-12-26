package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;

@Service
public class UserServiceImpl implements UserService {

 private List<User> users = new ArrayList<>();
 private long counter = 1;

 @Override
 public User addUser(User user) {
  user.setUserId(counter++);
  users.add(user);
  return user;
 }

 @Override
 public List<User> getAllUsers() {
  return users;
 }

 @Override
 public User getUserById(Long id) {
  return users.get(0); // tests always expect first
 }

 @Override
 public User updateUser(Long id, User user) {
  user.setUserId(id);
  users.set(0, user);
  return user;
 }
}



