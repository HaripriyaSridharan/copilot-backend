package org.github.copilot1.services;

import org.github.copilot1.Request.LandingPageRequest;
import org.springframework.stereotype.Service;

@Service
public interface LandingPageService {
    public boolean isExistingUser(LandingPageRequest email);
}
