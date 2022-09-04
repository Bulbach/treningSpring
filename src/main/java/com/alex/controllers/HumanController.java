package com.alex.controllers;

import com.alex.dto.HumanDto;
import com.alex.dto.PhoneDto;
import com.alex.service.HumanService;
import com.alex.service.PhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/humans")
@Api(value = "humanController")
public class HumanController {
    private final static Logger log = LoggerFactory.getLogger(HumanController.class);
    @Autowired
    private HumanService humanService;
    @Autowired
    private PhoneService phoneService;

    public void setHumanService(HumanService humanService) {
        this.humanService = humanService;
    }

    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }


    @RequestMapping(value = "/home")
    @ApiOperation("метод для отправки данных на страницу jsp")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<HumanDto> listHuman = humanService.getAll();
        modelAndView.addObject("listHuman", listHuman);

        return modelAndView;
    }

    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseBody
    @Transactional
    public ModelAndView createHuman(@RequestParam("phone") String phone, HumanDto humanDto) {
        log.debug("Method createHuman started");
        ModelAndView modelAndView = new ModelAndView("one");
        HumanDto humanDtoTemp = humanService.createHuman(humanDto);
        List<PhoneDto> phoneDtoList = createPhone(humanDtoTemp, phone);
        humanDtoTemp.setPhoneDtoList(phoneDtoList);
        modelAndView.addObject("human", humanDtoTemp);

        return modelAndView;
    }


    private List<PhoneDto> createPhone(HumanDto humanDto, String phone) {
        PhoneDto phoneDto = new PhoneDto();
        List<PhoneDto> dtoList = new ArrayList<>();

        phoneDto.setHumanDto(humanDto);
        phoneDto.setPhoneNumber(phone);
        PhoneDto tempDto = phoneService.createPhone(phoneDto);
        dtoList.add(tempDto);

        return dtoList;
    }


    @PostMapping(value = "/update")
    @ResponseBody
    @ApiOperation("изменение сущности")
    public ModelAndView updateHuman(HumanDto humanDto) {

        for (PhoneDto item : humanDto.getPhoneDtoList()) {
            item.setHumanDto(humanDto);
            phoneService.updatePhone(item);
        }

        humanService.updateHuman(humanDto);

        return new ModelAndView("redirect:/humans/home");
    }

    @GetMapping(value = "/update/{id}")
    @ResponseBody
    public ModelAndView updatePage(@PathVariable() Long id) {
        ModelAndView modelAndView = new ModelAndView("update");
        HumanDto humanDto = humanService.getById(id);
        modelAndView.addObject("human", humanDto);
        return modelAndView;
    }

    @GetMapping(value = "/{id}")
//    @ApiOperation("поиск по id")
    public ModelAndView getById(@PathVariable() Long id) {
        ModelAndView modelAndView = new ModelAndView("one");
        HumanDto humanDto = humanService.getById(id);
        modelAndView.addObject("human", humanDto);
        return modelAndView;
    }

    @GetMapping("/")
//    @ApiOperation("полный список сущностей")
    public ModelAndView getAll() {

        ModelAndView modelAndView = new ModelAndView("humans");
        List<HumanDto> listHumans = humanService.getAll();
        modelAndView.addObject("listHuman", listHumans);

        return modelAndView;
    }

    @PostMapping("/delete")
//    @ApiOperation("удаление сущьности")
    public String deleteHuman(@RequestParam("id") Long id) {
        humanService.delete(id);
        return "redirect:/humans/home";
    }

}
