package com.example.jwt_application.repo;

import com.example.jwt_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE user.username = :username")
    User findByUserName(String username);
}
