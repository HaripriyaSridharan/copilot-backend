package org.github.copilot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@ConfigurationPropertiesScan
@SpringBootApplication(nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
public class Copilot1Application {

    public static void main(String[] args) {
        SpringApplication.run(Copilot1Application.class, args);
    }

}
