package com.example.demo.admpol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.wololo.geojson.Geometry;

@Getter
@Setter
@AllArgsConstructor
public class AdmPolDTO {
    private long id;
    private long id2;
    private String uuid;
    private String code;
    private String objectName;
    private String obl;
    private String adm;
    private Geometry polygon;
}
