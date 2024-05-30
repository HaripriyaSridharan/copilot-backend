package org.github.copilot1.controller;

import java.util.List;
import org.github.copilot1.Response.GetRidesResponse;
import org.github.copilot1.models.Ride;
import org.github.copilot1.models.Rider;
import org.github.copilot1.services.PublishRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishRideController {

    @Autowired
    PublishRideService publishRideService;
    @PostMapping("/publishRide")
    public ResponseEntity<String> publishRide(@RequestBody Rider rider) {
        System.out.println(rider.toString());
        publishRideService.createRide(rider);
        return new ResponseEntity<>("Ride published successfully", HttpStatus.CREATED);
    }
    @GetMapping("/{id}/publishedRides")
    public ResponseEntity<List<GetRidesResponse>> getPublishedRides(@PathVariable String id){
        return new ResponseEntity<>(publishRideService.getPublishedRides(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}/cancelRide")
    public ResponseEntity<String> cancelRide(@PathVariable String id){
        publishRideService.cancelRide(id);
        return new ResponseEntity<>("Deleted the ride successfully", HttpStatus.OK);
    }
}
