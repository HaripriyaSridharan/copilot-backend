package org.github.copilot1.services;

import org.github.copilot1.dto.SetProfileRequest;
import org.springframework.stereotype.Service;

@Service
public interface SetProfileService {
    public void saveProfileDetails(SetProfileRequest setProfileRequest);

}
