package org.github.copilot1.serviceImplementation;

import org.github.copilot1.Request.SignUpRequest;
import org.github.copilot1.models.User;
import org.github.copilot1.repo.UserRepository;
import org.github.copilot1.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImplementation implements SignUpService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void savePassword(SignUpRequest signUpRequest) {
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        userRepository.save(user);
    }
}
