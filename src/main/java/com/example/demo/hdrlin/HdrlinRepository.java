package com.example.demo.hdrlin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HdrlinRepository extends JpaRepository<Hdrlin, Long> {
}

// st_within(A, B) - true, если геометрия A полностью внутри геометрии B
// st_equals(A, B) - true, если геометрии полностью пространственно равны
// st_disjoint(A, B) - true, если геометрии не имеют общих точек
// st_intersects(A, B) - true, если геометрии имеют хотя бы одну общую точку
// st_touches(A, B) - true, если геометрии соприкасаются
// st_crosses(A, B) - true, если есть общие точки и их количество меньше множества точек каждой геометрии
// st_contains(A, B) - true, если B полностью содержится внутри A
// st_overlaps(A, B) - true, если геометрии перекрываются, но не целиком
