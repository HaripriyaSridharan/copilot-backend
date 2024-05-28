package org.github.copilot1.serviceimplementation;

import java.util.Optional;
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
        Optional<User> optionalUser= userRepository.findById(setProfileRequest.getId());
        optionalUser.map(user -> {
            user.setFirstName(setProfileRequest.getFirstName());
            user.setLastName(setProfileRequest.getLastName());
            user.setPhoneNumber(setProfileRequest.getPhoneNumber());
            user.setGender(setProfileRequest.getGender());
            user.setProfileImage(setProfileRequest.getProfileImage());
            return user;
        }).ifPresent(userRepository::save);
    }

}
