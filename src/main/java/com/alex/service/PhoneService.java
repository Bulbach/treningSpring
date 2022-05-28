package com.alex.service;

import com.alex.dto.PhoneDto;
import com.alex.mappers.PhoneMapper;
import com.alex.model.Phone;
import com.alex.repository.PhoneDaoImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {
    private final PhoneDaoImpl phoneDao = getPhoneDao();
    private final PhoneMapper phoneMapper = getPhoneMapper();


    public PhoneDaoImpl getPhoneDao() {
        return phoneDao;
    }

    public PhoneMapper getPhoneMapper() {
        return phoneMapper;
    }

    public PhoneDto getById(Long id) {

        return phoneMapper.toDto((Phone) phoneDao.findOne(id));
    }

    public PhoneDto createPhone(PhoneDto phone) {
        Phone phone1 = phoneMapper.toModel(phone);

        return phoneMapper.toDto((Phone) phoneDao.create(phone1));
    }

    public void delete(Long id){
        phoneDao.deleteById(id);
    }

    public List<PhoneDto> getAll(){
        return (List<PhoneDto>) phoneDao.findAll()
                .stream()
                .map(p-> phoneMapper.toDto((Phone) p))
                .collect(Collectors.toList());
    }

    public void saveAll(List<PhoneDto> phoneDtoList){
        List<Phone> phoneList = phoneDtoList.stream()
                .map(phoneMapper::toModel)
                .collect(Collectors.toList());
        phoneDao.saveAll(phoneList);
    }

    public PhoneDto updatePhone(PhoneDto phoneDto) {
        Phone phoneById = (Phone) phoneDao.findOne(phoneDto.getId());
        phoneMapper.updatePhoneFromDto(phoneDto,phoneById);
        return phoneMapper.toDto((Phone) phoneDao.create(phoneById));
    }
}