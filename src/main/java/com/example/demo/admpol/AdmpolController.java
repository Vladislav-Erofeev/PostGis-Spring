package com.example.demo.admpol;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wololo.jts2geojson.GeoJSONWriter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/polygon")
public class AdmpolController {

    private final AdmService admService;
    private final AdmPolMapper admPolMapper = AdmPolMapper.INSTANCE;

    @GetMapping("/test")
    public ResponseEntity<String> start() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<AdmPolDTO> getAll() {
        List<AdmPol> admPols = admService.getAll();
        return admPols.stream().map(this::convertAdmPoltoAdmPolDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AdmPolDTO getById(@PathVariable("id") long id) throws Exception {
        AdmPol admPol = admService.getById(id);
        return convertAdmPoltoAdmPolDTO(admPol);
    }

    private AdmPolDTO convertAdmPoltoAdmPolDTO(AdmPol admPol) {
        AdmPolDTO admPolDTO = admPolMapper.admPolToAdmPolDTO(admPol);
        admPolDTO.setPolygon(new GeoJSONWriter().write(admPol.getPolygon()));
        return admPolDTO;
    }
}
