package com.alex.controllers;

import com.alex.dto.HumanDto;
import com.alex.dto.PhoneDto;
import com.alex.service.HumanService;
import com.alex.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/humans")
public class HumanController {

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
//    @ApiOperation("метод для отправки данных на страницу jsp")
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
        ModelAndView modelAndView = new ModelAndView("one");
        HumanDto humanDtoTemp = humanService.createHuman(humanDto);
        List<PhoneDto> phoneDtoList = createPhone(humanDtoTemp, phone);
        humanDtoTemp.setPhoneDtoList(phoneDtoList);
        modelAndView.addObject("human", humanDtoTemp);

        return modelAndView;
    }


    public List<PhoneDto> createPhone(HumanDto humanDto, String phone) {
        PhoneDto phoneDto = new PhoneDto();
        List<PhoneDto> dtoList = new ArrayList<>();

        phoneDto.setHumanDto(humanDto);
        phoneDto.setPhoneNumber(phone);
        PhoneDto tempDto = phoneService.createPhone(phoneDto);
        dtoList.add(tempDto);

        return dtoList;
    }
//    todo тоже самое переделать
//    @ApiOperation("изменение сущности")

    @PostMapping(value = "update")
    @Transactional
    @ResponseBody
    public ModelAndView updateHuman(HumanDto humanDto) {
        for (PhoneDto item:humanDto.getPhoneDtoList()){
            item.setHumanDto(humanDto);
            phoneService.updatePhone(item);
        }

        humanService.updateHuman(humanDto);

        return new ModelAndView("redirect:/humans/home");
    }

    @GetMapping(value = "update/{id}")
    @ResponseBody
    public ModelAndView updatePage(@PathVariable() Long id) {
        ModelAndView modelAndView = new ModelAndView("update");
        HumanDto humanDto = humanService.getById(id);
        modelAndView.addObject("human", humanDto);
        return modelAndView;
    }

    @GetMapping(value = "/{id}")
//    @ApiOperation("поиск по id")
    public String getById(@PathVariable() Long id, Model model) {
//        ModelAndView modelAndView = new ModelAndView("one");
//        HumanDto humanDto = humanService.getById(id);
//        modelAndView.addObject("human", humanDto);
//        return modelAndView;
//        return humanService.getById(id);
        HumanDto humanDto = humanService.getById(id);
        model.addAttribute("human", humanDto);
        return "one";
    }

    @GetMapping(value = "/api/{id}")
    @ResponseBody
    public HumanDto getByIdApi(@PathVariable() Long id, Model model) {
//        ModelAndView modelAndView = new ModelAndView("one");
//        HumanDto humanDto = humanService.getById(id);
//        modelAndView.addObject("human", humanDto);
//        return modelAndView;
//        return humanService.getById(id);
        HumanDto humanDto = humanService.getById(id);

        return humanDto;
    }


    @GetMapping("/")
//    @ApiOperation("полный список сущностей")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("humans");
        List<HumanDto> listHumans = humanService.getAll();
        modelAndView.addObject("listHuman", listHumans);
//        model.addAttribute("listHuman",humanService.getAll());
//        return "humans";
        return modelAndView;
    }

    //
    @PostMapping("delete")
//    @ApiOperation("удаление сущьности")
    public String deleteHuman(@RequestParam("id") Long id) {
        humanService.delete(id);
        return "redirect:/humans/home";
    }

    @GetMapping("/check")
    @ResponseBody
    public String check(ModelMap model) {
        return "Human controller pppp";
    }

    @GetMapping("/test")
    @ResponseBody
    public HumanDto humanDto() {
        HumanDto testDto = new HumanDto();
        testDto.setId(7L);
        testDto.setFirstname("Murlock");
        testDto.setLastname("Barmaglot");
        testDto.setCity("Hole");
        testDto.setStreet("long");
        testDto.setBirthday("20220224");
        return testDto;
    }
}
