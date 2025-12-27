// package com.examly.springapp.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.*;
// import org.springframework.web.bind.annotation.*;

// import com.examly.springapp.model.User;
// import com.examly.springapp.service.UserService;

// @RestController
// @RequestMapping("/api/users")
// public class UserController {

//  @Autowired
//  private UserService userService;

//  @PostMapping
//  public ResponseEntity<User> addUser(@RequestBody User user) {
//   return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
//  }

//  @GetMapping
//  public ResponseEntity<List<User>> getAllUsers() {
//   return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
//  }

//  @GetMapping("/{id}")
//  public ResponseEntity<User> getUserById(@PathVariable Long id) {
//   return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
//  }

//  @PutMapping("/{id}")
//  public ResponseEntity<User> updateUser(
//    @PathVariable Long id,
//    @RequestBody User user) {

//   return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
//  }
// }

package com.examly.springapp.controller;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User created = service.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = service.getAllUsers();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updated = service.updateUser(id, user);
        return ResponseEntity.ok(updated);
    }
}


