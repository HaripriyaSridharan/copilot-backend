package org.github.copilot1.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.github.copilot1.Response.GetRidesResponse;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Getter
@Setter
@ToString
@Document
public class Ride {
    @Id
    @GeneratedValue
    @Pattern(regexp = "^[0-9]+$")
    private String id;
    @Field
    private String passengerId;
    @Field
    private GetRidesResponse rideDetails;
    @Field
    private String createdTime;

    public Ride() {
        this.createdTime= LocalDateTime.now().toString();
    }
}
