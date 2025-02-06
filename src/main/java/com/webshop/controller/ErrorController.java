package com.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/error")
    public String modifyPage(Model model) {
        model.addAttribute("content", "error"); // Trỏ tới templates/general.html
        return "layout/master";
    }
}
