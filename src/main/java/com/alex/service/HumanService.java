package com.alex.service;

import com.alex.dto.HumanDto;
import com.alex.mappers.HumanMapper;
import com.alex.model.Human;
import com.alex.repository.HumanDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HumanService {
//    private final HumanDaoImpl humanDao = getHumanDao();
//    private final HumanMapper humanMapper = getHumanMapper();
//
//
//    public HumanDaoImpl getHumanDao() {
//        return humanDao;
//    }
//
//    public HumanMapper getHumanMapper() {
//        return humanMapper;
//    }

    private final HumanMapper humanMapper;
    private final HumanDaoImpl humanDao;

    @Autowired
    public HumanService(HumanMapper humanMapper, HumanDaoImpl humanDao) {
        this.humanMapper = humanMapper;
        this.humanDao = humanDao;
    }


    public HumanDto getById(Long id) {

        return humanMapper.toDto((Human) humanDao.findOne(id));
    }

    public HumanDto createHuman(HumanDto human) {
        Human human1 = humanMapper.toModel(human);

        return humanMapper.toDto((Human) humanDao.create(human1));
    }


    public void delete(Long id) {
        humanDao.deleteById(id);
    }

    public List<HumanDto> getAll() {
        List<Human> humanList = humanDao.findAll();
        System.out.println(humanList);
        if (humanList == null){
            return Collections.emptyList();
        }
        return (List<HumanDto>) humanDao.findAll()
                .stream()
                .map(h->  humanMapper.toDto((Human) h))
                .collect(Collectors.toList());
    }

    public void saveAll(List<HumanDto> humanDtoList) {
        List<Human> humanList = humanDtoList.stream()
                .map(humanMapper::toModel)
                .collect(Collectors.toList());
        humanDao.saveAll(humanList);
    }

    public HumanDto updateHuman(HumanDto humanDto) {
        Human humanById = (Human) humanDao.findOne(humanDto.getId());
        humanMapper.updateHumanFromDto(humanDto, humanById);

        return humanMapper.toDto((Human) humanDao.create(humanById));
    }
}
