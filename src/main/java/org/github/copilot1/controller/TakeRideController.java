package org.github.copilot1.controller;

import java.util.List;
import org.github.copilot1.models.Passenger;
import org.github.copilot1.models.Rider;
import org.github.copilot1.services.NodalPointService;
import org.github.copilot1.services.TakeRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TakeRideController {

    @Autowired
    NodalPointService nodalPointService;

    @Autowired
    TakeRideService takeRideService;

    @GetMapping("/getNodalPoints")
    public ResponseEntity<List<String>> getNodalPoints() {
        System.out.println("Getting nodal points");
        return new ResponseEntity<>(nodalPointService.getNodalPoints(), HttpStatus.OK);
    }

    @PostMapping("/takeRide")
    public ResponseEntity<List<Rider>> takeRide(@RequestBody Passenger passenger) {
        System.out.println("Taking ride");
        return new ResponseEntity<>(takeRideService.getRides(passenger), HttpStatus.OK);
    }

    @PostMapping("/loadNodes")
    public ResponseEntity<String> loadNodes() {
        System.out.println("Loading nodes");
        nodalPointService.loadNodes();
        return new ResponseEntity<>("Nodes loaded successfully", HttpStatus.OK);
    }
}
