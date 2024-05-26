package org.github.copilot1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Getter
@Setter
@Document(collection = "users")
public class User {


    @Field
    @GeneratedValue
    private String id;
    @Id
    private String email;
    @Field
    private String password;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private Vehicle vehicle;
    @Field
    private String gender;
    @Field
    private String phoneNumber;
    @Field
    private String profileImage;

}