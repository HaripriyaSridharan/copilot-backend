package org.github.copilot1.services;

import org.github.copilot1.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User addUser(User user);

    public void deleteUser(String id);

    public User saveUser(String id, User user);

    public String getUserFirstName(String id);

    public String getUserIdByEmail(String email);

    public User getUser(String id);
}
