package com.alex.controllers;

import com.alex.service.PhoneService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    private final PhoneService phoneService = getPhoneService();

    public PhoneService getPhoneService() {
        return phoneService;
    }

//    @PostMapping("/add")
//    @ApiOperation("добавление телефона")
//    public PhoneDto createPhone(@RequestBody PhoneDto phoneDto) {
//        return phoneService.createPhone(phoneDto);
//    }
//
//    todo переделать дичь лютая была
//    @PostMapping("/update")
//    @ApiOperation("изменение телефона")
//    public PhoneDto updatePhone(@RequestBody PhoneDto phoneDto) {
//        return phoneService.updatePhone(phoneDto);
//    }
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