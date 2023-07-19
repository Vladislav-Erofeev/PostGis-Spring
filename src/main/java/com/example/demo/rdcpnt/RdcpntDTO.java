package com.example.demo.rdcpnt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.wololo.geojson.Geometry;

@Getter
@Setter
@AllArgsConstructor
public class RdcpntDTO {
    private long id;
    private Geometry geometry;
    private String objname;
    private String name;
}
