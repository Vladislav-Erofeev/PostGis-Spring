package com.example.demo.rdcpnt;

import org.locationtech.jts.geom.Polygon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdcpntRepository extends JpaRepository<Rdcpnt, Long> {

    @Query(value = "select * from rdcpnt r where public.st_within(r.sp_geometry, :polygon) = true", nativeQuery = true)
    List<Rdcpnt> findAllInArea(@Param("polygon")Polygon polygon);
}
