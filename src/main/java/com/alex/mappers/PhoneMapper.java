package com.alex.mappers;

import com.alex.dto.PhoneDto;
import com.alex.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
//        (uses = HumanMapper.class)
public interface PhoneMapper {
    @Mapping(source = "human",target = "humanDto")
    PhoneDto toDto(Phone phone);
    @Mapping(source = "humanDto",target = "human")
    Phone toModel(PhoneDto phone);
    @Mapping(source = "humanDto",target = "human")
    Phone updatePhoneFromDto(PhoneDto dto, @MappingTarget Phone phone);
}
