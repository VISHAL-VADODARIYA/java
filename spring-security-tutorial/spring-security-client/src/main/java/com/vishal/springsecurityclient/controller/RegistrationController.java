package com.vishal.springsecurityclient.controller;

import com.vishal.springsecurityclient.entity.User;
import com.vishal.springsecurityclient.event.RegistrationCompleteEvent;
import com.vishal.springsecurityclient.model.UserModel;
import com.vishal.springsecurityclient.repository.UserRepository;
import com.vishal.springsecurityclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user,"url"));
        return "Success !!";
    }
}
