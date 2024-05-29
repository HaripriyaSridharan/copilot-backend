package org.github.copilot1.repo;

import org.github.copilot1.models.Rider;
import org.github.copilot1.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RiderRepository extends MongoRepository<Rider, String> {
    @Query("{'from': ?0, 'to': ?1, 'dateTime': {$gt: ?2}}")
    List<Rider> findByFromAndToAndTimeAfter(String from, String to, LocalDateTime time);
}
