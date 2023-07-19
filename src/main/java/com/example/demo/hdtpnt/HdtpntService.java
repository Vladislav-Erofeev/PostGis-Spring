package com.example.demo.hdtpnt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Polygon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HdtpntService {
    private final HdtpntRepository hdtpntRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public List<Hdtpnt> getAll() {
        return hdtpntRepository.findAll();
    }

    public List<Hdtpnt> getInArea(Polygon polygon) {
        return hdtpntRepository.getAllPoints(polygon);
    }
}
