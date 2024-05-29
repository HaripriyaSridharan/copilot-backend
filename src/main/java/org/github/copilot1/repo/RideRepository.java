package org.github.copilot1.repo;

import org.github.copilot1.models.Ride;
import org.github.copilot1.models.Rider;
import org.github.copilot1.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RideRepository extends MongoRepository<Ride, String> {
    Ride findFirstByOrderByCreatedTimeDesc();
}
