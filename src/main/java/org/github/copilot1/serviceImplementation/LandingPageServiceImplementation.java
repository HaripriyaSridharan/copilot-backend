package org.github.copilot1.serviceImplementation;

import org.github.copilot1.dto.LandingPageRequest;
import org.github.copilot1.repo.UserRepository;
import org.github.copilot1.services.LandingPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandingPageServiceImplementation implements LandingPageService {

    @Autowired
    UserRepository userRepository;
    @Override
    public boolean isExistingUser(LandingPageRequest email) {
        return userRepository.existsByEmail(email.getEmail());
    }
}
