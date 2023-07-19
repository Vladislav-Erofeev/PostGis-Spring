package com.example.demo.bldpol;

import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.Polygon;

@Entity
@Data
@Table(name = "bldpol")
public class Bldpol {
    @Id
    @GeneratedValue
    @Column(name = "_id")
    private long id;

    @Column(name = "sp_geometry")
    private Polygon polygon;

    @Column(name = "\"OBJNAME\"")
    private String objname;

    @Column(name = "\"ADDRESS\"")
    private String address;
}
