package com.example.system__cccd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.system__cccd.entity.Sample;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
}
