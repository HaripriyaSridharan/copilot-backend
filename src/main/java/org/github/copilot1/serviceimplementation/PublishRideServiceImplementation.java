package org.github.copilot1.serviceimplementation;

import java.util.List;
import org.github.copilot1.Response.GetRidesResponse;
import org.github.copilot1.models.Rider;
import org.github.copilot1.repo.RiderRepository;
import org.github.copilot1.services.PublishRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishRideServiceImplementation implements PublishRideService {

    @Autowired
    RiderRepository riderRepository;

    @Autowired
    serviceUtils serviceUtils;

    @Override
    public void createRide(Rider rider) {
        riderRepository.save(rider);
    }
    @Override
    public List<GetRidesResponse> getPublishedRides(String id) {
        List<Rider> rides = riderRepository.findByUserId(id);
        return serviceUtils.formatRiderResponse(rides);

    }
    @Override
    public void cancelRide(String id) {
        riderRepository.deleteById(id);
    }
}
