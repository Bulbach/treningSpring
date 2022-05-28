package com.alex.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/humans")
public class HumanController {
    @GetMapping("/check")
    public String check(ModelMap model) {
        return "Human controller dddddd";
    }
}
