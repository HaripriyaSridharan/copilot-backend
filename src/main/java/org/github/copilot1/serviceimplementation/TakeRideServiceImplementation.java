package org.github.copilot1.serviceimplementation;

import org.github.copilot1.models.Passenger;
import org.github.copilot1.models.Rider;
import org.github.copilot1.repo.RiderRepository;
import org.github.copilot1.services.TakeRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TakeRideServiceImplementation implements TakeRideService {

    @Autowired
    private RiderRepository riderRepository;

    @Override
    public List<Rider> getRides(Passenger passenger) {
        return riderRepository.findByFromAndToAndTimeAfter(passenger.getFrom(), passenger.getTo(), passenger.getDateTime());
    }
}
