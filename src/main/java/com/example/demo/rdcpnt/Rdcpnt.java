package com.example.demo.rdcpnt;

import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.Point;

@Entity
@Data
@Table(name = "rdcpnt")
public class Rdcpnt {
    @Id
    @GeneratedValue
    @Column(name = "_id")
    private long id;

    @Column(name = "sp_geometry")
    private Point point;

    @Column(name = "\"OBJNAME\"")
    private String objname;

    @Column(name = "\"NAME\"")
    private String name;
}
