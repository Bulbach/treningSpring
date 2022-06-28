package com.alex.controllers;

import com.alex.dto.PhoneDto;
import com.alex.service.HumanService;
import com.alex.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private HumanService humanService;

       public PhoneService getPhoneService() {
        return phoneService;
    }

    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    public HumanService getHumanService() {
        return humanService;
    }

    public void setHumanService(HumanService humanService) {
        this.humanService = humanService;
    }

    @PostMapping("/add")
    public ModelAndView createPhone(@RequestParam("id") Long id, @RequestParam("phone") String phone) {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setHumanDto(humanService.getById(id));
        phoneDto.setPhoneNumber(phone);
        phoneService.createPhone(phoneDto);
        return new ModelAndView("redirect:/humans/home");
    }

//    todo переделать дичь лютая была
    @PostMapping("/update")
    public PhoneDto updatePhone(@RequestBody PhoneDto phoneDto) {
        return phoneService.updatePhone(phoneDto);
    }
//
//    @GetMapping("/get/{id}")
//    @ApiOperation("поиск по id")
//    public PhoneDto getById(@PathVariable("id") Long id){
//        return phoneService.getById(id);
//    }
//    @GetMapping("/phones")
//    @ApiOperation("полный список сущностей")
//    public List<PhoneDto> getAll(){
//        return phoneService.getAll();
//    }
//    @DeleteMapping("/{id}")
//    public void deletePhone(@PathVariable("id") Long id){
//        phoneService.delete(id);
//    }

    @GetMapping("/check")
    public String check(ModelMap model) {
        return "Phone controller ggg";
    }
}