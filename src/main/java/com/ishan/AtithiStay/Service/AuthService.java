package com.ishan.AtithiStay.Service;

import com.ishan.AtithiStay.dto.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
void signup(SignupRequest signupRequest);
}
