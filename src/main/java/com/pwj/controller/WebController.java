package com.pwj.controller;

import com.pwj.domain.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class WebController implements WebMvcConfigurer {
    // 配置一个简单的自动controller
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/resultsTest").setViewName("results");
    }

    @GetMapping("/validForm")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping("/validPerson")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/resultsTest";
    }
}
