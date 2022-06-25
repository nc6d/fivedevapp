package com.five.auth.model.dto;

import com.five.auth.model.authorities.Role;
import lombok.Data;

@Data
public class RegisteredDto {

    private String firstName;

    private String lastName;

    private String email;

    private Role role;

}
