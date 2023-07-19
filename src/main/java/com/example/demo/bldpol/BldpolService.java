package com.example.demo.bldpol;

import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Polygon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BldpolService {
    private final BldpolRepository bldpolRepository;

    public List<Bldpol> getAllInArea(Polygon polygon) {
        return bldpolRepository.getAllInArea(polygon);
    }
}
