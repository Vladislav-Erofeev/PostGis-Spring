package com.example.demo.bldpol;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BldpolMapper {
    BldpolMapper INSTANCE = Mappers.getMapper(BldpolMapper.class);

    @Mapping(target = "geometry", ignore = true)
    BldpolDTO convertToBldpolDTO(Bldpol bldpol);
}
