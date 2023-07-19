package com.example.demo.bldpol;

import com.example.demo.admpol.AdmPol;
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
@RequestMapping("/bld")
@RequiredArgsConstructor
public class BbldpolController {
    private final BldpolService bldpolService;
    private final AdmService admService;
    private final BldpolMapper bldpolMapper = BldpolMapper.INSTANCE;

    @GetMapping("/area")
    public List<BldpolDTO> getAllInArea() throws Exception {
        AdmPol admPol = admService.getAll().get(0);
        Polygon polygon = admPol.getPolygon();
        List<Bldpol> result = bldpolService.getAllInArea(polygon);
        System.out.println(admPol.getId() + "  :   " + admPol.getAdm());
        System.out.println(result.size());
        return result.stream().map(this::convertToBldpolDTO).collect(Collectors.toList());
    }

    @GetMapping("/crosses")
    public List<BldpolDTO> getAllCrossesArea() {
        AdmPol admPol = admService.getAll().get(1);
        Polygon polygon = admPol.getPolygon();
        List<Bldpol> result = bldpolService.getAllCrossesArea(polygon);
        System.out.println(admPol.getId() + "  :   " + admPol.getAdm());
        System.out.println(result.size());
        return result.stream().map(this::convertToBldpolDTO).collect(Collectors.toList());
    }

    private BldpolDTO convertToBldpolDTO(Bldpol bldpol) {
        BldpolDTO bldpolDTO = bldpolMapper.convertToBldpolDTO(bldpol);
        bldpolDTO.setGeometry(new GeoJSONWriter().write(bldpol.getPolygon()));
        return bldpolDTO;
    }
}
