package org.github.copilot1.controller;

import java.util.List;
import org.github.copilot1.Response.PassengerInfo;
import org.github.copilot1.Response.RiderInfo;
import org.github.copilot1.models.Ride;
import org.github.copilot1.services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RideController {

    @Autowired
    RideService rideService;
    @PostMapping("/getlatestRide")
    public ResponseEntity<Ride> getlatestRide(@RequestParam String riderId, @RequestParam String passengerId) {
        return new ResponseEntity<>(rideService.getLatestRide(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/createRide")
    public ResponseEntity<Ride> createRide(@RequestBody Ride ride) {
        rideService.createRide(ride);
        return new ResponseEntity<>(rideService.getLatestRide(), HttpStatus.CREATED);
    }
    @GetMapping("/{id}/passengerInfo")
    public ResponseEntity<PassengerInfo> getPassengerInfo(@PathVariable String id) {
        return new ResponseEntity<>(rideService.getPassengerInfo(id), HttpStatus.CREATED);
    }
    @GetMapping("/{id}/riderInfo")
    public ResponseEntity<RiderInfo> getRiderInfo(@PathVariable String id) {
        return new ResponseEntity<>(rideService.getRiderInfo(id), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}/deleteRide")
    public ResponseEntity<String> deleteRide(@PathVariable String id) {
        rideService.deleteRide(id);
        return new ResponseEntity<>("Ride deleted", HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}/bookedRides")
    public ResponseEntity<List<Ride>> getBookedRides(@PathVariable String id){
          return new ResponseEntity<>(rideService.getBookedRides(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/getRide")
    public ResponseEntity<Ride> getRide(@PathVariable String id){
        return new ResponseEntity<>(rideService.getRide(id), HttpStatus.OK);
    }
}
