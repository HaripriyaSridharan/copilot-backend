package org.github.copilot1.services;

import org.github.copilot1.models.User;
import org.github.copilot1.utils.AuthenticationResult;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public AuthenticationResult authenticate(User userCredentials);

}
