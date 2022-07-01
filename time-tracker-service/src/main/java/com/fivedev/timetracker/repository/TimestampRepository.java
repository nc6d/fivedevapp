package com.fivedev.timetracker.repository;

import com.fivedev.timetracker.model.Timestamp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimestampRepository extends MongoRepository<Timestamp, Long> {
}
