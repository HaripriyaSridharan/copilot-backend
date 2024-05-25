package org.github.copilot1.models;

import nonapi.io.github.classgraph.json.Id;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Vehicle {

    @Id
    private String vechileId;
    private String email;
    private String vehicleType;

}
