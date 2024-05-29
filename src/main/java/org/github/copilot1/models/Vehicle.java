package org.github.copilot1.models;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.data.couchbase.core.mapping.Document;


@Getter
@Setter
public class Vehicle {

    @Id
    private String vehicleId;
    private String userId;
    private String vehicleType;
    private String vehicleNumber;
    public Vehicle() {
        this.vehicleId = UUID.randomUUID().toString();
    }

}
