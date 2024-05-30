package org.github.copilot1.serviceimplementation;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.github.copilot1.Response.GetRidesResponse;
import org.github.copilot1.models.NodalPoint;
import org.github.copilot1.models.Passenger;
import org.github.copilot1.models.Rider;
import org.github.copilot1.models.User;
import org.github.copilot1.models.Vehicle;
import org.github.copilot1.repo.NodalPointRepository;
import org.github.copilot1.repo.RiderRepository;
import org.github.copilot1.repo.UserRepository;
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
    @Autowired
    private serviceUtils serviceUtils;


    @Override
    public  List<GetRidesResponse> getRides(Passenger passenger) {
        LocalDateTime timePlus24Hours = passenger.getDateTime().plusHours(24);
        List<Rider> rides = riderRepository.findByFromAndToAndTimeAfterAndWithin24Hours(passenger.getFrom(), passenger.getTo(), passenger.getDateTime(), timePlus24Hours);
        return serviceUtils.formatRiderResponse(rides, passenger);
    }

}
