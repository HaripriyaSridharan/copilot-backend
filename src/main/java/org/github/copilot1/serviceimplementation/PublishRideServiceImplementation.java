package org.github.copilot1.serviceimplementation;

import org.github.copilot1.models.Rider;
import org.github.copilot1.repo.RiderRepository;
import org.github.copilot1.services.PublishRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishRideServiceImplementation implements PublishRideService {

    @Autowired
    RiderRepository riderRepository;

    @Override
    public void createRide(Rider rider) {
        riderRepository.save(rider);
    }
}
