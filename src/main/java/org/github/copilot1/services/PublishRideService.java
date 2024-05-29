package org.github.copilot1.services;

import lombok.Setter;
import org.github.copilot1.models.Rider;
import org.springframework.stereotype.Service;

@Service
public interface PublishRideService {

    public void createRide(Rider rider);
}
