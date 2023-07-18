package com.example.demo.hdtpnt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HdtpntRepository extends JpaRepository<Hdtpnt, Long> {
}
