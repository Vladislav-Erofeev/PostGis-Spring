package com.example.demo.hdrlin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.locationtech.jts.geom.LineSegment;
import org.locationtech.jts.geom.LineString;

@Entity
@Data
public class Hdrlin {
    @Id
    @GeneratedValue
    @Column(name = "_id")
    private long id;

    @Column(name = "sp_geometry")
    private LineString lineSegment;

    @Column(name = "\"ID\"")
    private long id2;

    @Column(name = "\"UUID\"")
    private String uuid;

    @Column(name = "\"CODE\"")
    private String code;

    @Column(name = "\"OBJNAME\"")
    private String objectName;

    @Column(name = "\"NAME\"")
    private String name;

    @Column(name = "\"WID\"")
    private Integer wid;
}
