package org.github.copilot1.services;


import org.github.copilot1.dto.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public interface SignUpService {
    public void savePassword(SignUpRequest signUpRequest) ;
}
