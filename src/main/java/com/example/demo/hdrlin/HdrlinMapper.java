package com.example.demo.hdrlin;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HdrlinMapper {
    HdrlinMapper INSTANCE = Mappers.getMapper(HdrlinMapper.class);

    @Mapping(target = "geometry", ignore = true)
    HdrlinDTO convertHdrlinToHdrlinDTO(Hdrlin hdrlin);
}
