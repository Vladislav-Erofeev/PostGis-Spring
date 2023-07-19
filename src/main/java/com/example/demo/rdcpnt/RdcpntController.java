package com.example.demo.rdcpnt;

import com.example.demo.admpol.AdmService;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Polygon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wololo.jts2geojson.GeoJSONWriter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rdc")
public class RdcpntController {
    private final RdcpntService rdcpntService;
    private final AdmService admService;
    private final RdcpntMapper rdcpntMapper = RdcpntMapper.INSTANCE;

    @GetMapping("/all")
    public List<RdcpntDTO> getALl(@RequestParam(name = "limit", defaultValue = "10", required = false) int limit,
                                  @RequestParam(name = "page", defaultValue = "0", required = false) int page) {
        return rdcpntService.getAll(limit, page).stream().map(this::convertToRdcpntDTO).collect(Collectors.toList());
    }

    @GetMapping("/area")
    public List<RdcpntDTO> getInArea() throws Exception {
        Polygon polygon = admService.getById(225).getPolygon();
        return rdcpntService.getAllInArea(polygon).stream().map(this::convertToRdcpntDTO).collect(Collectors.toList());
    }

    private RdcpntDTO convertToRdcpntDTO(Rdcpnt rdcpnt) {
        RdcpntDTO rdcpntDTO = rdcpntMapper.convertToRdcpntDTO(rdcpnt);
        rdcpntDTO.setGeometry(new GeoJSONWriter().write(rdcpnt.getPoint()));
        return rdcpntDTO;
    }
}
