package com.example.demo.admpol;

import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.Polygon;

@Entity
@Data
@Table(name = "admpol")
public class AdmPol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "_id")
    private long id;

    @Column(name = "sp_geometry", columnDefinition = "Geometry")
    private Polygon polygon;

    @Column(name = "\"ID\"")
    private long id2;

    @Column(name = "\"UUID\"")
    private String uuid;

    @Column(name = "\"CODE\"")
    private String code;

    @Column(name = "\"OBJNAME\"")
    private String objectName;

    @Column(name = "\"OBL\"")
    private String obl;

    @Column(name = "\"ADM\"")
    private String adm;

    @Column(name = "\"CONT\"")
    private int cont;
}
