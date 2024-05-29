package org.github.copilot1.services;

import java.util.List;
import org.github.copilot1.models.Passenger;
import org.github.copilot1.models.Rider;
import org.springframework.stereotype.Service;

@Service
public interface TakeRideService {
    public List<Rider> getRides(Passenger passenger);
}
