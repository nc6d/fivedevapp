package com.fivedev.timetracker.controller;

import com.fivedev.timetracker.model.Timestamp;
import com.fivedev.timetracker.model.dto.SaveRecordDto;
import com.fivedev.timetracker.service.TimestampService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimestampController {

    TimestampService timestampService;
    ModelMapper modelMapper;

    @Autowired
    public TimestampController(TimestampService timestampService, ModelMapper modelMapper) {
        this.timestampService = timestampService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/record/save")
    public ResponseEntity<Timestamp> testRequest(@RequestBody SaveRecordDto dto) {
        Timestamp result = timestampService.saveTimestamp(modelMapper.map(dto, Timestamp.class));
        return ResponseEntity.ok(result);
    }

}
