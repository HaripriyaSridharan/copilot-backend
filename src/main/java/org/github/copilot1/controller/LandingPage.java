package org.github.copilot1.controller;



import org.github.copilot1.Request.LandingPageRequest;
import org.github.copilot1.services.LandingPageService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingPage {

    @Autowired
    LandingPageService landingPageService;

    @PostMapping("/validateEmail")
    public ResponseEntity<Object> validateEmail(@RequestBody LandingPageRequest email) {

        if (landingPageService.isExistingUser(email)){
            return new ResponseEntity<>("Sign In", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sign Up", HttpStatus.OK);
        }
    }
}