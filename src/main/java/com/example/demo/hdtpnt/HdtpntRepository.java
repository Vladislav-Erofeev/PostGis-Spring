package com.example.demo.hdtpnt;

import com.example.demo.admpol.AdmPol;
import org.locationtech.jts.geom.Polygon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HdtpntRepository extends JpaRepository<Hdtpnt, Long> {
    @Query(value = "select * from hdtpnt h where public.st_contains(h.sp_geometry, :polygon) = false", nativeQuery = true)
    List<Hdtpnt> getAllPoints(@Param("polygon") Polygon polygon);
}
