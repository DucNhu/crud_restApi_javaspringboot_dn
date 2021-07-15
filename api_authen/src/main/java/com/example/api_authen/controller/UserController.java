package com.example.api_authen.controller;

import com.example.api_authen.models.Role;
import com.example.api_authen.models.User;
import com.example.api_authen.models.UserRole;
import com.example.api_authen.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private userService userService;

    @PostMapping("/register")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles= new HashSet<>();

        Role role = new Role();
        role.setRoleId(50L);
        role.setRoleName("ADMIN");

        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        roles.add(userRole);
        return this.userService.createUser(user, roles);
    }

    @GetMapping("/getInfor/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    @DeleteMapping("/deleteUser/{userid}")
    public void deleteUser(@PathVariable("userid") Long userid){
         this.userService.deleteUser(userid);
    }
}
