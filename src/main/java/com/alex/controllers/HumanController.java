package com.alex.controllers;

import com.alex.dto.HumanDto;
import com.alex.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/humans")
public class HumanController {

    @Autowired
    private HumanService humanService;

    public void setHumanService(HumanService humanService) {
        this.humanService = humanService;
    }

    @RequestMapping(value = "/home")
//    @ApiOperation("метод для отправки данных на страницу jsp")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<HumanDto> listHuman = humanService.getAll();
        modelAndView.addObject("listHuman", listHuman);
//        model.addAttribute("listHuman", humanService.getAll());
//        return "index";
        return modelAndView;
    }

    //        @PostMapping("/add_human")
//    @ApiOperation("добавление новой сущности")
//    public String createHuman(@RequestBody HumanDto humanDto, Model model) {
//        model.addAttribute("human", humanService.createHuman(humanDto));
//        return "index";
//    }
//
//    todo тоже самое переделать
//    @PostMapping("update_human")
//    @ApiOperation("изменение сущности")
//    public HumanDto updateHuman(@RequestBody HumanDto humanDto) {
//        return humanService.updateHuman(humanDto);
//    }
//
    @GetMapping(value = "/find-by-id/{id}")
//    @ApiOperation("поиск по id")
    public ModelAndView getById(@PathVariable() Long id) {
        ModelAndView modelAndView = new ModelAndView("index");
        HumanDto humanDto = humanService.getById(id);
        modelAndView.addObject("human", humanDto);
        return modelAndView;
//        return humanService.getById(id);
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
//    @DeleteMapping("delete/{id}")
//    @ApiOperation("удаление сущьности")
//    public void deleteHuman(Long id) {
//        humanService.delete(id);
//    }

    @GetMapping("/check")
    public String check(ModelMap model) {
        return "Human controller pppp";
    }

    @GetMapping("/test")
    public HumanDto humanDto(){
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
