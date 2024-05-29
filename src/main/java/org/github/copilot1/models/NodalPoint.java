package org.github.copilot1.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "nodal_points")
public class NodalPoint {

    @Id
    private String id;
    private String node;
    private double distance;
}
