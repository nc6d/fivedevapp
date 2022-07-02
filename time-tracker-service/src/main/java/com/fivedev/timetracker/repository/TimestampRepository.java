package com.fivedev.timetracker.repository;

import com.fivedev.timetracker.model.Timestamp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimestampRepository extends MongoRepository<Timestamp, Long> {
}
