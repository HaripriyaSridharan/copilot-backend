package org.github.copilot1.repo;

import org.github.copilot1.models.User;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
}

//@N1qlPrimaryIndexed
//@ViewIndexed(designDoc="User",viewName="all")
//public interface UserRepository extends CouchbaseRepository<User, String>{
//
//}
//public interface UserRepository extends JpaRepository<User, String> {
//}