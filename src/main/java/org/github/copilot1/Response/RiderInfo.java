package org.github.copilot1.Response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.List;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.github.copilot1.models.Vehicle;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class RiderInfo {


    private String riderId;

    private String email;

    private String name;


    private String vehicleType;

    private String vehicleNumber;


    private String contact;


    private String profileImage;

    private String from;

    private String to;



}

