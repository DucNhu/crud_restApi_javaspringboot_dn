package com.example.api_authen.dao;

import com.example.api_authen.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select username From users where username = username")
    public User findByusername(String userName);
}
