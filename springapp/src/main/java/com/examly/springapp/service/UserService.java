// package com.examly.springapp.service;

// import java.util.List;
// import com.examly.springapp.model.User;

// public interface UserService {

//  User addUser(User user);

//  List<User> getAllUsers();

//  User getUserById(Long id);

//  User updateUser(Long id, User user);
// }



package com.examly.springapp.service;

import com.examly.springapp.model.User;
import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User user);
}
