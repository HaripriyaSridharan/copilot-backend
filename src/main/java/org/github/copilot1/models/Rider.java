package org.github.copilot1.models;


import com.mongodb.internal.connection.Time;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "rider")
public class Rider {
    private String id;
    private String userId;
    private String vehicleId;
    private String to;
    private String from;
    private LocalDateTime dateTime;

}
