package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.Set;

public interface UserService {

    // create user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    // get user by userName
    public User getUser(String Username);

    //delete user by Id
    public void deleteUser(Long Id);

}
