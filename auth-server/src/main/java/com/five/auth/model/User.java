package com.five.auth.model;

import com.five.auth.model.authorities.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document("users")
public class User {

    @Id
    private BigInteger id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Role role;

}