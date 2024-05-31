package org.github.copilot1.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "routes")
public class Route {

    @Id
    private String id;
    private String userId;
    private Location source;
    private Location destination;
    private List<Location> waypoints;
    private String polyline;

}
