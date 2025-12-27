// package com.examly.springapp.repository;

// import org.springframework.stereotype.Repository;

// @Repository
// public class UserRepository {
// }

package com.examly.springapp.repository;

import com.examly.springapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}


