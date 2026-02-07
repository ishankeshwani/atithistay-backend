package com.ishan.AtithiStay.Service.impl;

import com.ishan.AtithiStay.dto.SignupRequest;
import com.ishan.AtithiStay.Repository.UserRepository;
import com.ishan.AtithiStay.Service.AuthService;
import com.ishan.AtithiStay.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public void signup(SignupRequest signupRequest) {


        // 1. Check if email already exists
        if (userRepository.findByEmail(signupRequest.getEmail()).isPresent()){
            throw new RuntimeException("Email Already Exists");
        }

        // Convert Dto TO Entity
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());

        // save to database
        userRepository.save(user);

    }
}
