package com.fivedev.timetracker.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;

@Data
public class User {

    @Id
    private BigInteger id;

    private String firstName;

    private String lastName;
}
