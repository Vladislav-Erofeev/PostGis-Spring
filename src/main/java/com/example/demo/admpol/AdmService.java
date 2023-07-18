package com.example.demo.admpol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdmService {

    private final AdmPolRepository admPolRepository;

    public AdmPol getById(long id) throws Exception {
        Optional<AdmPol> optionalAdmPol = admPolRepository.findById(id);
        if (optionalAdmPol.isEmpty())
            throw new Exception();
        return optionalAdmPol.get();
    }

    public List<AdmPol> getAll() {
        return admPolRepository.findAll();
    }
}
