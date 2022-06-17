package com.alex.controllers;

import com.alex.dto.HumanDto;
import com.alex.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
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

    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//    @ApiOperation("добавление новой сущности")
//    @ResponseBody
    public void createHuman(@RequestBody HumanDto humanDto) {
//        ModelAndView modelAndView = new ModelAndView("one");
//        model.addAttribute("human", humanService.createHuman(humanDto));
        HumanDto humanDtoTemp = humanService.createHuman(humanDto);
//        modelAndView.addObject("human", humanDtoTemp);

//        return modelAndView;
    }
//    @PostMapping(value = "/add")
//    public Map<String, Object> createHuman(@RequestBody HumanDto humanDto) {
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("human", humanService.updateHuman(humanDto));
//        return map;
////        return humanService.createHuman(humanDto);
//    }
    /*
    @RequestMapping(
  value = "/greetings-with-map-return-type",
  method = RequestMethod.GET,
  produces = "application/json"
)
@ResponseBody
public Map<String, Object> getGreetingWhileReturnTypeIsMap() {
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("test", "Hello from map");
    return map;
}
     */

    //
//    todo тоже самое переделать
//    @ApiOperation("изменение сущности")

    @PostMapping(value = "update")
    @ResponseBody
    public void updateHuman(@RequestBody HumanDto humanDto) {
        humanService.updateHuman(humanDto);
        home();
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
    @DeleteMapping("delete/{id}")
//    @ApiOperation("удаление сущьности")
    public void deleteHuman(@PathVariable Long id) {
        humanService.delete(id);
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
