package com.alex.mappers;

import com.alex.dto.HumanDto;
import com.alex.model.Human;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = PhoneMapper.class)
public interface HumanMapper {

    HumanDto toDto(Human human);

    Human toModel(HumanDto humanDto);

    void updateHumanFromDto(HumanDto dto, @MappingTarget Human human);
}