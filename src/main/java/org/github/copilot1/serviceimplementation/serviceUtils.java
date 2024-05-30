package org.github.copilot1.serviceimplementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.github.copilot1.Response.GetRidesResponse;
import org.github.copilot1.models.NodalPoint;
import org.github.copilot1.models.Passenger;
import org.github.copilot1.models.Rider;
import org.github.copilot1.models.User;
import org.github.copilot1.models.Vehicle;
import org.github.copilot1.repo.NodalPointRepository;
import org.github.copilot1.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class serviceUtils {
    @Autowired
    NodalPointRepository nodalPointRepository;
    @Autowired
    UserRepository userRepository;

    public List<GetRidesResponse> formatRiderResponse(List<Rider> rides){
        List<GetRidesResponse> responses = new ArrayList<>();
        System.out.println("Rides found: "+rides.size());
        for (Rider ride : rides) {
            GetRidesResponse response = new GetRidesResponse();
            User user = userRepository.findById(ride.getUserId()).get();
            response.setPublishedRideId(ride.getId());
            response.setRiderId(ride.getUserId());
            response.setName(generateName(user));
            response.setType(getType(ride,user));
            response.setGender(user.getGender());
            response.setTime(formatTime(ride));
            response.setDate(formatDate(ride));
            response.setFrom(ride.getFrom());
            response.setTo(ride.getTo());
            responses.add(response);
        }
        return responses;
    }
    public List<GetRidesResponse> formatRiderResponse(List<Rider> rides, Passenger passenger){
        List<GetRidesResponse> responses = new ArrayList<>();
        System.out.println("Rides found: "+rides.size());
        for (Rider ride : rides) {
            GetRidesResponse response = new GetRidesResponse();
            User user = userRepository.findById(ride.getUserId()).get();
            response.setPublishedRideId(ride.getId());
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
        if(distance<3){
            return "90.00";
        }
        else{
            distance = distance-3;
        }
        double fare = (distance * 10)+90;
        return String.format("%.2f", fare);
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
