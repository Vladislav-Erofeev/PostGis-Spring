package com.example.demo.hdtpnt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HdtpntService {
    private final HdtpntRepository hdtpntRepository;

    public List<Hdtpnt> getAll() {
        return hdtpntRepository.findAll();
    }
}
