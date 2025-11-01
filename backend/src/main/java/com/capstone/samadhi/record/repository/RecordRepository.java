package com.capstone.samadhi.record.repository;

import com.capstone.samadhi.record.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    //Page<Record> findByUser(User user, Pageable pageable);
}
