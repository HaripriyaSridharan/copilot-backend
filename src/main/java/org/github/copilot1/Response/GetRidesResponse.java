package org.github.copilot1.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRidesResponse {

    private String publishedRideId;
    private String riderId;
    private String type;
    private String name;
    private String time;
    private String date;
    private String gender;
    private String fare;
    private String from;
    private String to;
}
