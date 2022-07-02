package com.fivedev.timetracker.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class Timestamp {
    @Id
    private BigInteger id;

    private LocalDate date;

    private Double value;

    private String username;

}
