package com.example.demo.hdtpnt;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HdtpntMapper {
    HdtpntMapper INSTANCE = Mappers.getMapper(HdtpntMapper.class);

    @Mapping(target = "geometry", ignore = true)
    HdtpntDTO convertHdtpntToHdtpntDTO(Hdtpnt hdtpnt);
}
