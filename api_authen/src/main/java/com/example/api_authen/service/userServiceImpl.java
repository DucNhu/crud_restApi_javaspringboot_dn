package com.example.api_authen.service;

import com.example.api_authen.dao.RoleRepository;
import com.example.api_authen.dao.UserRepository;
import com.example.api_authen.models.User;
import com.example.api_authen.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class userServiceImpl implements userService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User userInDb = userRepository.findByusername(user.getUsername());
       if(userInDb != null) { // check
           System.out.println("User is already there!");
           throw new Exception("User already present!");
       } else {
           for(UserRole ur:userRoles) {
               roleRepository.save(ur.getRole());
           }
           user.getUserRoles().addAll(userRoles);
           userInDb = this.userRepository.save(user);
       }
        return userInDb; // ret user
    }

    // get user infor by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByusername(username);
    }

    @Override
    public void deleteUser(Long userid) {
        this.userRepository.deleteById(userid);
    }

    @Override
    public List<User> getall() {
        return userRepository.findAll();
    }
}
