package com.example.demo.hdtpnt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.wololo.geojson.Geometry;

@Getter
@Setter
@AllArgsConstructor
public class HdtpntDTO {
    private long id;
    private Geometry geometry;
    private long id2;
    private String uuid;
    private String code;
    private String objectName;
    private String caption;
    private int cont;
}
