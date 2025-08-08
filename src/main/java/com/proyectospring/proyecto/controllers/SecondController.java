package com.proyectospring.proyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/wawa")
public class SecondController {
    @GetMapping("/wiwi")
    public String index(Model model) {

        model.
        return "wiwi";
    }
}
