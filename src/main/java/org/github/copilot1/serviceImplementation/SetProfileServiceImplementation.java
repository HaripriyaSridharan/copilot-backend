package org.github.copilot1.serviceImplementation;

import org.github.copilot1.dto.SetProfileRequest;
import org.github.copilot1.models.User;
import org.github.copilot1.repo.UserRepository;
import org.github.copilot1.services.SetProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetProfileServiceImplementation implements SetProfileService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveProfileDetails(SetProfileRequest setProfileRequest) {
        User user= userRepository.findFirstByOrderByIdDesc();
        user.setFirstName(setProfileRequest.getFirstName());
        user.setLastName(setProfileRequest.getLastName());
        user.setPhoneNumber(setProfileRequest.getPhoneNumber());
        user.setGender(setProfileRequest.getGender());
        user.setProfileImage(setProfileRequest.getProfileImage());
        userRepository.save(user);
    }

}
