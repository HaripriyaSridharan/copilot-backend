package org.github.copilot1.services;

import java.util.ArrayList;
import java.util.List;
import org.github.copilot1.models.Location;
import org.github.copilot1.models.Route;
import org.github.copilot1.repo.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public List<Route> validateRideShare(Route newRoute, double thresholdDistance) {
        List<Route> routes = getAllRoutes();
        List<Route> matchedRoutes = new ArrayList<>();

        for (Route route : routes) {
            if (isRouteWithin(newRoute.getWaypoints(), route.getWaypoints(), thresholdDistance)) {
                matchedRoutes.add(route);
            }
        }
        return matchedRoutes;
    }


    private boolean isRouteWithin(List<Location> newWaypoints, List<Location> existingWaypoints, double threshold) {
        // Check if the new route's waypoints lie entirely within the existing route's waypoints
        for (Location newWaypoint : newWaypoints) {
            boolean match = existingWaypoints.stream().anyMatch(existingWaypoint ->
                calculateDistance(newWaypoint, existingWaypoint) <= threshold);
            if (!match) {
                return false;
            }
        }
        return true;
    }

    private double calculateDistance(Location point1, Location point2) {
        double earthRadius = 6371.0; // kilometers
        double dLat = Math.toRadians(point2.getLatitude() - point1.getLatitude());
        double dLng = Math.toRadians(point2.getLongitude() - point1.getLongitude());
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
            + Math.cos(Math.toRadians(point1.getLatitude())) * Math.cos(Math.toRadians(point2.getLatitude()))
            * Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }
}

