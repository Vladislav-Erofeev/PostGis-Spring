package com.example.demo.hdtpnt;

import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.Point;

@Entity
@Data
@Table(name = "hdtpnt")
public class Hdtpnt {

    @Id
    @GeneratedValue
    @Column(name = "_id")
    private long id;

    @Column(name = "sp_geometry")
    private Point point;

    @Column(name = "\"ID\"")
    private long id2;

    @Column(name = "\"UUID\"")
    private String uuid;

    @Column(name = "\"CODE\"")
    private String code;

    @Column(name = "\"OBJNAME\"")
    private String objectName;

    @Column(name = "\"CAPTION\"")
    private String caption;

    @Column(name = "\"CONT\"")
    private int cont;
}
