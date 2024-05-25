//package org.github.copilot1.config;
//
//import com.couchbase.client.java.Cluster;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
//
//@Configuration
//@EnableCouchbaseRepositories(basePackages = "org.github.copilot1.repo")
//public class CouchbaseDbConfig {
//
//    @Value("${spring.couchbase.connection-string}")
//    private String connectionString;
//
//    @Value("${spring.couchbase.username}")
//    private String username;
//    @Value("${spring.couchbase.password}")
//    private String password;
//
//    @Bean
//    public Cluster couchbaseCluster() {
//        return Cluster.connect(connectionString, username, password);
//    }
//}