package org.github.copilot1.models;


import com.mongodb.internal.connection.Time;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger {
    private String id;
    private String from;
    private String to;
    private LocalDateTime dateTime;
}
