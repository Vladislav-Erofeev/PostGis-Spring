package com.example.demo.bldpol;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Polygon;
import org.wololo.geojson.Geometry;

@Getter
@Setter
@AllArgsConstructor
public class BldpolDTO {
    private long id;
    private Geometry geometry;
    private String objname;
    private String address;
}
