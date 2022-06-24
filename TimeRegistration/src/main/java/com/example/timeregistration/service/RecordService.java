package com.example.timeregistration.service;

import com.example.timeregistration.model.TimeRecord;
import com.example.timeregistration.repo.TimeRecordRepository;
import com.example.timeregistration.repo.UserRepository;
import com.example.timeregistration.security.jwt.JwtTokenProvider;
import com.example.timeregistration.security.jwt.JwtUser;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;
import com.example.timeregistration.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@Service
public class RecordService {

    UserRepository userRepository;
    TimeRecordRepository timeRecordRepository;

    public RecordService(UserRepository userRepository, TimeRecordRepository timeRecordRepository) {
        this.userRepository = userRepository;
        this.timeRecordRepository = timeRecordRepository;
    }

    public TimeRecord saveRecord(TimeRecord timeRecord) {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();


        JwtUser o = ((JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User userRepo = userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("User authentication error"));
        timeRecord.setUser(userRepo);
        return timeRecordRepository.save(timeRecord);

    }

    private void getEmailFromApiGatewayServer() {
        // TODO: 20-Jun-22 implement getEmail (api-gateway-server) and bring it to here with RestTemplate

    }


}
