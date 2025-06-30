package com.exam.controller;

import com.exam.helper.UserFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        //encoding password with bcryptpasswodEncryption
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Role role = new Role(2L,"NORMAL");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        Set<UserRole> roles = new HashSet<>();
        roles.add(userRole);
        return userService.createUser(user,roles);
    }

    // get user by userName
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username")String userName){
        return this.userService.getUser(userName);
    }

    //delete by id
    @DeleteMapping("/{uid}")
    public void deleteUser(@PathVariable("uid")Long uid){
        userService.deleteUser(uid);
    }

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex){
        return ResponseEntity.ok(ex.getMessage());
    }

}
