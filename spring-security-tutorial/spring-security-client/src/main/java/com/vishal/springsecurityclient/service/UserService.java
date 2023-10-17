package com.vishal.springsecurityclient.service;

import com.vishal.springsecurityclient.entity.User;
import com.vishal.springsecurityclient.model.UserModel;

public interface UserService {
    public User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
