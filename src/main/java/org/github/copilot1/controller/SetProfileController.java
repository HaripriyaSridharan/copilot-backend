package org.github.copilot1.controller;


import org.github.copilot1.dto.SetProfileRequest;
import org.github.copilot1.services.SetProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetProfileController {

    @Autowired
    private  SetProfileService setProfileService;

    @PostMapping("/setProfile")
    public ResponseEntity<String> setProfile(@RequestBody SetProfileRequest setProfileRequest) {
        System.out.println("Setting profile");
        setProfileService.saveProfileDetails(setProfileRequest);
        return ResponseEntity.ok("Profile details saved successfully");
    }
}