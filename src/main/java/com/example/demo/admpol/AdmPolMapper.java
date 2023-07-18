package com.example.demo.admpol;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdmPolMapper {
    AdmPolMapper INSTANCE = Mappers.getMapper(AdmPolMapper.class);

    @Mapping(target = "polygon", ignore = true)
    AdmPolDTO admPolToAdmPolDTO(AdmPol admPol);
}
