package org.github.copilot1.repo;

import java.util.Optional;
import org.github.copilot1.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    boolean existsByEmail(String email);
    @Query(sort = "{ '_id': -1 }")
    User findFirstByOrderByIdDesc();
}
