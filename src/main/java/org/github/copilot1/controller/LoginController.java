package org.github.copilot1.controller;

import org.github.copilot1.models.User;
import org.github.copilot1.services.LoginService;
import org.github.copilot1.utils.AuthenticationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User credentials) {
        if (credentials.getEmail() == null || credentials.getPassword() == null) {
            return ResponseEntity.badRequest().body("Invalid request");
        }

        AuthenticationResult result = loginService.authenticate(credentials);
        if (result.isAuthenticated()) {
            return ResponseEntity.ok("Authentication successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
