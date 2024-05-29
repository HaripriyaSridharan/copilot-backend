package org.github.copilot1.repo;

import org.github.copilot1.models.NodalPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodalPointRepository extends MongoRepository<NodalPoint, String> {
}
