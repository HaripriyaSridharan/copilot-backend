package org.github.copilot1.services;

import org.github.copilot1.Response.PassengerInfo;
import org.github.copilot1.Response.RiderInfo;
import org.github.copilot1.models.Ride;
import org.springframework.stereotype.Service;

@Service
public interface RideService {
    public void createRide(Ride ride);
//    public void getPassengerRideDetails(String riderId, String passengerId);
    public Ride getLatestRide();
    public RiderInfo getRiderInfo(String riderId);
    public PassengerInfo getPassengerInfo(String passengerId);
    public void deleteRide(String id);
}
