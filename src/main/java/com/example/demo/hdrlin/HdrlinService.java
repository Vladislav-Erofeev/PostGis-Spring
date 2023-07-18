package com.example.demo.hdrlin;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HdrlinService {
    private final HdrlinRepository hdrlinRepository;

    public List<Hdrlin> getAll() {
        return hdrlinRepository.findAll(Pageable.ofSize(10).withPage(0)).getContent();
    }
}
