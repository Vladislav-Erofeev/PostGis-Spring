package com.example.demo.admpol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmPolRepository extends JpaRepository<AdmPol, Long> {
}
