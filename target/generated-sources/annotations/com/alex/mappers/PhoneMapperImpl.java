package com.alex.mappers;

import com.alex.dto.HumanDto;
import com.alex.dto.PhoneDto;
import com.alex.model.Human;
import com.alex.model.Phone;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-10T03:12:16+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
public class PhoneMapperImpl implements PhoneMapper {

    @Override
    public PhoneDto toDto(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDto phoneDto = new PhoneDto();

        phoneDto.setHumanDto( humanToHumanDto( phone.getHuman() ) );
        phoneDto.setId( phone.getId() );
        phoneDto.setPhoneNumber( phone.getPhoneNumber() );

        return phoneDto;
    }

    @Override
    public Phone toModel(PhoneDto phone) {
        if ( phone == null ) {
            return null;
        }

        Phone phone1 = new Phone();

        phone1.setHuman( humanDtoToHuman( phone.getHumanDto() ) );
        if ( phone.getId() != null ) {
            phone1.setId( phone.getId() );
        }
        phone1.setPhoneNumber( phone.getPhoneNumber() );

        return phone1;
    }

    @Override
    public Phone updatePhoneFromDto(PhoneDto dto, Phone phone) {
        if ( dto == null ) {
            return null;
        }

        if ( dto.getHumanDto() != null ) {
            if ( phone.getHuman() == null ) {
                phone.setHuman( new Human() );
            }
            humanDtoToHuman1( dto.getHumanDto(), phone.getHuman() );
        }
        else {
            phone.setHuman( null );
        }
        if ( dto.getId() != null ) {
            phone.setId( dto.getId() );
        }
        phone.setPhoneNumber( dto.getPhoneNumber() );

        return phone;
    }

    protected HumanDto humanToHumanDto(Human human) {
        if ( human == null ) {
            return null;
        }

        HumanDto humanDto = new HumanDto();

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

    protected Human humanDtoToHuman(HumanDto humanDto) {
        if ( humanDto == null ) {
            return null;
        }

        Human human = new Human();

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

    protected void humanDtoToHuman1(HumanDto humanDto, Human mappingTarget) {
        if ( humanDto == null ) {
            return;
        }

        mappingTarget.setId( humanDto.getId() );
        mappingTarget.setLastname( humanDto.getLastname() );
        mappingTarget.setFirstname( humanDto.getFirstname() );
        if ( humanDto.getBirthday() != null ) {
            mappingTarget.setBirthday( LocalDate.parse( humanDto.getBirthday() ) );
        }
        else {
            mappingTarget.setBirthday( null );
        }
        mappingTarget.setCity( humanDto.getCity() );
        mappingTarget.setStreet( humanDto.getStreet() );
    }
}
