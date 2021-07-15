package com.example.api_authen.service;

import com.example.api_authen.models.User;
import com.example.api_authen.models.UserRole;

import java.util.List;
import java.util.Set;

public interface userService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUser(Long userid);

    public List<User> getall();
}
