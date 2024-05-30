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
    private NodalPointRepository nodalPointRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public  List<GetRidesResponse> getRides(Passenger passenger) {
        List<Rider> rides=  riderRepository.findByFromAndToAndTimeAfter(passenger.getFrom(), passenger.getTo(), passenger.getDateTime());
        List<GetRidesResponse> responses = new ArrayList<>();
        System.out.println("Rides found: "+rides.size());
        for (Rider ride : rides) {
            GetRidesResponse response = new GetRidesResponse();
            User user = userRepository.findById(ride.getUserId()).get();
            response.setRideId(ride.getId());
            response.setRiderId(ride.getUserId());
            response.setName(generateName(user));
            response.setType(getType(ride,user));
            response.setGender(user.getGender());
            response.setFare(getFare(passenger));
            response.setTime(formatTime(ride));
            response.setDate(formatDate(ride));
            responses.add(response);
        }
        return responses;
    }

    private String getFare(Passenger passenger) {

         NodalPoint fromNode = nodalPointRepository.findByNode(passenger.getFrom());
         NodalPoint toNode = nodalPointRepository.findByNode(passenger.getTo());
         double distance= fromNode.getDistance()>toNode.getDistance()?fromNode.getDistance()-toNode.getDistance():toNode.getDistance()-fromNode.getDistance();

        double fare = distance * 50;
        return Double.toString(fare);
    }


    private String formatTime(Rider ride){
        LocalDateTime dateTime = ride.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
       return dateTime.format(formatter);
    }
    private String formatDate(Rider ride){
        LocalDateTime dateTime = ride.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yyyy");
        return dateTime.format(formatter);
    }

    private String generateName(User user){
        return user.getFirstName() + " " + user.getLastName();
    }
    private String getType(Rider ride,User user){
        List<Vehicle> vehicles = user.getVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(ride.getVehicleId())) {
                return vehicle.getVehicleType();
            }
        }
        return null;
    }

}
