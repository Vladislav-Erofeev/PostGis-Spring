package com.example.demo.hdrlin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HdrlinRepository extends JpaRepository<Hdrlin, Long> {
}
