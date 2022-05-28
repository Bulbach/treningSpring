package com.alex.mappers;

import com.alex.dto.PhoneDto;
import com.alex.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = HumanMapper.class)
public interface PhoneMapper {

    PhoneDto toDto(Phone phone);

    Phone toModel(PhoneDto phone);

    void updatePhoneFromDto(PhoneDto dto, @MappingTarget Phone phone);
}
