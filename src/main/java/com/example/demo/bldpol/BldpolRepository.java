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
    List<Bldpol> findAllInArea(@Param("area")Polygon polygon);

    @Query(value = "select * from bldpol " +
            "where public.st_overlaps(bldpol.sp_geometry, :area) = true", nativeQuery = true)
    List<Bldpol> findAllCrossesArea(@Param("area") Polygon polygon);
}

// st_within(A, B) - true, если геометрия A полностью внутри геометрии B
// st_equals(A, B) - true, если геометрии полностью пространственно равны
// st_disjoint(A, B) - true, если геометрии не имеют общих точек
// st_intersects(A, B) - true, если геометрии имеют хотя бы одну общую точку
// st_touches(A, B) - true, если геометрии соприкасаются
// st_crosses(A, B) - true, если есть общие точки и их количество меньше множества точек каждой геометрии
// st_contains(A, B) - true, если B полностью содержится внутри A
// st_overlaps(A, B) - true, если геометрии перекрываются, но не целиком
