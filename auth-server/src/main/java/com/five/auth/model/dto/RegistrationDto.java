package com.five.auth.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class RegistrationDto {

    @Pattern(regexp = "^([\\w\\s]){2,50}$", message = "Input valid name(2..50 chars including whitespaces)")
    private String firstName;

    @Pattern(regexp = "^([\\w\\s]){2,50}$", message = "Input valid name(2..50 chars including whitespaces)")
    private String lastName;

    @Pattern(regexp = "^\\w{1,70}@\\w{1,20}\\.\\w{1,10}$",
            message = "Input email 2..100 chars, should include exactly one @ and one dot")
    private String email;

    @Pattern(regexp = "^\\w{2,50}$", message = "Input password [a-zA-Z0-9_] (2..50 chars)")
    private String password;

}
