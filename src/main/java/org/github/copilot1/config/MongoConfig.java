package org.github.copilot1.config;

import org.github.copilot1.models.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.index.IndexInfo;

@Configuration
public class MongoConfig {

    @Bean
    public CommandLineRunner ensureIndexes(MongoTemplate mongoTemplate) {
        return args -> {
            IndexOperations indexOps = mongoTemplate.indexOps(User.class);

            // Check if index on email exists
            boolean indexExists = indexOps.getIndexInfo().stream()
                    .anyMatch(indexInfo -> indexInfo.getIndexFields().stream()
                            .anyMatch(field -> field.getKey().equals("email")));

            if (indexExists) {
                // Drop the index on email
                // We need to find the exact name of the index to drop it
                for (IndexInfo indexInfo : indexOps.getIndexInfo()) {
                    if (indexInfo.getIndexFields().stream()
                            .anyMatch(field -> field.getKey().equals("email"))) {
                        // Drop the index by its name
                        indexOps.dropIndex(indexInfo.getName());
                        break;
                    }
                }
            }

            // Create new unique index on email
            indexOps.ensureIndex(new Index().on("email", Direction.ASC).unique());
        };
    }
}
