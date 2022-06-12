package com.alex.mappers;

import com.alex.dto.HumanDto;
import com.alex.model.Human;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = PhoneMapper.class)
public interface HumanMapper {
//    @Mapping(source = "id" , target = "idDto")
    @Mapping(source = "phones",target = "phoneDtoList")
    HumanDto toDto(Human human);

//    @Mapping(source = "idDto", target = "id")
    @Mapping(source = "phoneDtoList",target = "phones")
    Human toModel(HumanDto humanDto);

    void updateHumanFromDto(HumanDto dto, @MappingTarget Human human);
}