package org.github.copilot1.serviceimplementation;

import java.util.List;
import org.github.copilot1.Response.PassengerInfo;
import org.github.copilot1.Response.RiderInfo;
import org.github.copilot1.models.Ride;
import org.github.copilot1.models.User;
import org.github.copilot1.repo.RideRepository;
import org.github.copilot1.repo.UserRepository;
import org.github.copilot1.services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImplementation implements RideService {

    @Autowired
    private RideRepository rideRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createRide(Ride ride) {
        rideRepository.save(ride);
    }
    private String generateName(User user){
        return user.getFirstName() + " " + user.getLastName();
    }

    public PassengerInfo getPassengerInfo(String passengerId) {
        PassengerInfo passengerInfo =new PassengerInfo();
        passengerInfo.setPassengerId(passengerId);
         userRepository.findById(passengerId).ifPresent(user -> {
          passengerInfo.setEmail(user.getEmail());
          passengerInfo.setName(generateName(user));
          passengerInfo.setContact(user.getPhoneNumber());
          passengerInfo.setProfileImage(user.getProfileImage());
        });
         return passengerInfo;
    }

    @Override
    public void deleteRide(String id) {
        rideRepository.deleteById(id);
    }

    @Override
    public List<Ride> getBookedRides(String id) {
        return rideRepository.findByPassengerId(id);
    }
    @Override
    public List<Ride> getPublishedRides(String id) {
        return rideRepository.findByRiderIdInRideDetails(id);
    }

    public RiderInfo getRiderInfo(String riderId) {
        RiderInfo riderInfo =new RiderInfo();
        riderInfo.setRiderId(riderId);
        userRepository.findById(riderId).ifPresent(user -> {
            riderInfo.setEmail(user.getEmail());
            riderInfo.setName(generateName(user));
            riderInfo.setContact(user.getPhoneNumber());
            riderInfo.setProfileImage(user.getProfileImage());
        });
        return riderInfo;
    }
    @Override
    public Ride getLatestRide() {
        return rideRepository.findFirstByOrderByCreatedTimeDesc();
    }
    @Override
    public Ride getRide(String id) {
        return rideRepository.findById(id).get();
    }
}
