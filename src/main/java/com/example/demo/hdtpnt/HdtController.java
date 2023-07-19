package com.example.demo.hdtpnt;

import com.example.demo.admpol.AdmService;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Polygon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wololo.jts2geojson.GeoJSONWriter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/point")
@RequiredArgsConstructor
public class HdtController {
    private final HdtpntService hdtpntService;
    private final AdmService admService;
    private final HdtpntMapper hdtpntMapper = HdtpntMapper.INSTANCE;

    @GetMapping("/all")
    public List<HdtpntDTO> getAll() {
        return hdtpntService.getAll().stream().map(this::convertToHdtpntDTO).collect(Collectors.toList());
    }

    @GetMapping("/area")
    public List<HdtpntDTO> getInArea() throws Exception {
        Polygon polygon = admService.getById(225).getPolygon();
        return hdtpntService.getInArea(polygon).stream().map(this::convertToHdtpntDTO).collect(Collectors.toList());
    }

    private HdtpntDTO convertToHdtpntDTO(Hdtpnt hdtpnt) {
        HdtpntDTO hdtpntDTO = hdtpntMapper.convertHdtpntToHdtpntDTO(hdtpnt);
        hdtpntDTO.setGeometry(new GeoJSONWriter().write(hdtpnt.getPoint()));
        return hdtpntDTO;
    }
}
