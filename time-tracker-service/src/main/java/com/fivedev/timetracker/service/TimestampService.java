package com.fivedev.timetracker.service;

import com.fivedev.timetracker.model.Timestamp;
import com.fivedev.timetracker.repository.TimestampRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TimestampService {

    TimestampRepository timestampRepository;

    public TimestampService(TimestampRepository timestampRepository) {
        this.timestampRepository = timestampRepository;
    }

    public Timestamp saveTimestamp(Timestamp timestamp) {
        String user = getUserFromSecurityService();
        timestamp.setUsername(user);
        return timestampRepository.save(timestamp);
    }

    private String getUserFromSecurityService() {
        final RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:6000/auth/get-email", String.class);
        return response.getBody();
    }
}
