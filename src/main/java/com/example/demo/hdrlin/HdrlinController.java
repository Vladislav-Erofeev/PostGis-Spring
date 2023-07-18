package com.example.demo.hdrlin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wololo.jts2geojson.GeoJSONWriter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/line")
public class HdrlinController {
    private final HdrlinService hdrlinService;
    private final HdrlinMapper hdrlinMapper = HdrlinMapper.INSTANCE;

    @GetMapping("/all")
    public List<HdrlinDTO> getAll() {
        return hdrlinService.getAll().stream().map(this::convertToHdrlinDTO).collect(Collectors.toList());
    }

    private HdrlinDTO convertToHdrlinDTO(Hdrlin hdrlin) {
        HdrlinDTO hdrlinDTO = hdrlinMapper.convertHdrlinToHdrlinDTO(hdrlin);
        hdrlinDTO.setGeometry(new GeoJSONWriter().write(hdrlin.getLineSegment()));
        return hdrlinDTO;
    }
}
