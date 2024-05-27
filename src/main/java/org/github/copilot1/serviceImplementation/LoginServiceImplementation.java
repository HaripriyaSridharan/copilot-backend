package org.github.copilot1.serviceImplementation;

import java.util.Optional;
import org.github.copilot1.models.User;
import org.github.copilot1.repo.UserRepository;
import org.github.copilot1.services.LoginService;
import org.github.copilot1.utils.AuthenticationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplementation implements LoginService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public AuthenticationResult authenticate(User userCredentials) {
        String email = userCredentials.getEmail();
        String password = userCredentials.getPassword();
        User user = userRepository.findByEmail(email);
            if (user.getPassword().equals(password)) {
                return new AuthenticationResult(true, user);
            }
        return new AuthenticationResult(false, null);
    }
}
