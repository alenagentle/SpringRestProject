package com.simbirsoft.rest.controller;

import com.simbirsoft.rest.dto.PersonDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
    @RequestMapping("/")
    public String welcome() {
        return "index";
    }
}
