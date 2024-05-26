package org.github.copilot1.controller;

import org.github.copilot1.dto.SignUpRequest;
import org.github.copilot1.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @Autowired
    SignUpService signUpService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest signUpRequest) {
        System.out.println("Signing up");
        signUpService.savePassword(signUpRequest);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}