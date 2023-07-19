package com.example.demo.bldpol;

import org.locationtech.jts.geom.Polygon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BldpolRepository extends JpaRepository<Bldpol, Long> {

    @Query(value = "select * from bldpol " +
            "where public.st_intersects(bldpol.sp_geometry, :area) = true", nativeQuery = true)
    List<Bldpol> getAllInArea(@Param("area")Polygon polygon);
}
