package org.github.copilot1.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRidesResponse {

    private String rideId;
    private String riderId;
    private String type;
    private String name;
    private String time;
    private String date;
    private String gender;
    private String fare;
}
