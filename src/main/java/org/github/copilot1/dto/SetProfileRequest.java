package org.github.copilot1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetProfileRequest {

    private String id;
    private String profileImage;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String  gender;
}
