package org.github.copilot1.services;

import java.util.List;
import lombok.Setter;
import org.github.copilot1.Response.GetRidesResponse;
import org.github.copilot1.models.Rider;
import org.springframework.stereotype.Service;

@Service
public interface PublishRideService {

    public void createRide(Rider rider);

    List<GetRidesResponse> getPublishedRides(String id);

    void cancelRide(String id);
}
