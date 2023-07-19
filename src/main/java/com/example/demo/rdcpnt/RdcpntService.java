package com.example.demo.rdcpnt;

import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Polygon;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RdcpntService {
    private final RdcpntRepository rdcpntRepository;

    public List<Rdcpnt> getAllInArea(Polygon polygon) {
        return rdcpntRepository.findAllInArea(polygon);
    }

    public List<Rdcpnt> getAll(int limit, int page) {
        return rdcpntRepository.findAll(Pageable.ofSize(limit).withPage(page)).getContent();
    }
}
