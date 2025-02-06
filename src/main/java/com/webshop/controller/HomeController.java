package com.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("content", "index");
        return "layout/master";
    }

    @GetMapping("/index")
    public String indexPage(Model model) {
        model.addAttribute("content", "index");
        return "layout/master";
    }

    @GetMapping("/product")
    public String productPage(Model model) {
        model.addAttribute("content", "product");
        return "layout/master";
    }

    @GetMapping("/e-commerce")
    public String eCommercePage(Model model) {
        model.addAttribute("content", "e-commerce");
        return "layout/master";
    }

    @GetMapping("/general")
    public String addPage(Model model) {
        model.addAttribute("content", "general");
        return "layout/master";
    }

    @GetMapping("/general/{id}")
    public String editProduct(Model model) {
        model.addAttribute("content", "general");
        return "layout/master";
    }

    @GetMapping("/modify")
    public String modifyPage(Model model) {
        model.addAttribute("content", "modify");
        return "layout/master";
    }

}
