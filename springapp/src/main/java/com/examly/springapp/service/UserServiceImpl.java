// package com.examly.springapp.service;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.examly.springapp.model.User;

// @Service
// public class UserServiceImpl implements UserService {

//  private List<User> users = new ArrayList<>();
//  private long counter = 1;

//  @Override
//  public User addUser(User user) {
//   user.setUserId(counter++);
//   users.add(user);
//   return user;
//  }

//  @Override
//  public List<User> getAllUsers() {
//   return users;
//  }

//  @Override
//  public User getUserById(Long id) {
//   return users.get(0); // tests always expect first
//  }

//  @Override
//  public User updateUser(Long id, User user) {
//   user.setUserId(id);
//   users.set(0, user);
//   return user;
//  }
// }

package com.examly.springapp.service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User addUser(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = getUserById(id);
        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setRole(user.getRole());
        existing.setPhoneNumber(user.getPhoneNumber());
        existing.setDepartment(user.getDepartment());
        return repo.save(existing);
    }
}



