package com.alex.mappers;

import com.alex.dto.HumanDto;
import com.alex.dto.PhoneDto;
import com.alex.model.Human;
import com.alex.model.Phone;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-26T09:57:01+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
public class HumanMapperImpl implements HumanMapper {

    private final PhoneMapper phoneMapper = Mappers.getMapper( PhoneMapper.class );

    @Override
    public HumanDto toDto(Human human) {
        if ( human == null ) {
            return null;
        }

        HumanDto humanDto = new HumanDto();

        humanDto.setPhoneDtoList( phoneListToPhoneDtoList( human.getPhones() ) );
        humanDto.setId( human.getId() );
        humanDto.setLastname( human.getLastname() );
        humanDto.setFirstname( human.getFirstname() );
        humanDto.setCity( human.getCity() );
        humanDto.setStreet( human.getStreet() );
        if ( human.getBirthday() != null ) {
            humanDto.setBirthday( DateTimeFormatter.ISO_LOCAL_DATE.format( human.getBirthday() ) );
        }

        return humanDto;
    }

    @Override
    public Human toModel(HumanDto humanDto) {
        if ( humanDto == null ) {
            return null;
        }

        Human human = new Human();

        human.setPhones( phoneDtoListToPhoneList( humanDto.getPhoneDtoList() ) );
        human.setId( humanDto.getId() );
        human.setLastname( humanDto.getLastname() );
        human.setFirstname( humanDto.getFirstname() );
        if ( humanDto.getBirthday() != null ) {
            human.setBirthday( LocalDate.parse( humanDto.getBirthday() ) );
        }
        human.setCity( humanDto.getCity() );
        human.setStreet( humanDto.getStreet() );

        return human;
    }

    @Override
    public void updateHumanFromDto(HumanDto dto, Human human) {
        if ( dto == null ) {
            return;
        }

        if ( human.getPhones() != null ) {
            List<Phone> list = phoneDtoListToPhoneList( dto.getPhoneDtoList() );
            if ( list != null ) {
                human.getPhones().clear();
                human.getPhones().addAll( list );
            }
            else {
                human.setPhones( null );
            }
        }
        else {
            List<Phone> list = phoneDtoListToPhoneList( dto.getPhoneDtoList() );
            if ( list != null ) {
                human.setPhones( list );
            }
        }
        human.setId( dto.getId() );
        human.setLastname( dto.getLastname() );
        human.setFirstname( dto.getFirstname() );
        if ( dto.getBirthday() != null ) {
            human.setBirthday( LocalDate.parse( dto.getBirthday() ) );
        }
        else {
            human.setBirthday( null );
        }
        human.setCity( dto.getCity() );
        human.setStreet( dto.getStreet() );
    }

    protected List<PhoneDto> phoneListToPhoneDtoList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDto> list1 = new ArrayList<PhoneDto>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneMapper.toDto( phone ) );
        }

        return list1;
    }

    protected List<Phone> phoneDtoListToPhoneList(List<PhoneDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDto phoneDto : list ) {
            list1.add( phoneMapper.toModel( phoneDto ) );
        }

        return list1;
    }
}
