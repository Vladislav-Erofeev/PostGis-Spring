package com.example.demo.rdcpnt;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RdcpntMapper {
    RdcpntMapper INSTANCE = Mappers.getMapper(RdcpntMapper.class);

    @Mapping(target = "geometry", ignore = true)
    RdcpntDTO convertToRdcpntDTO(Rdcpnt rdcpnt);
}
