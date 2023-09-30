package com.yvzucrks.springboot.thymeleafdemo.controller;

import com.yvzucrks.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${favorite_languages}")
    private List<String> favoriteLanguages;


    @GetMapping("/showStudentForm")
    public String showDForm(Model themodel) {
        //create new Student
        Student theStudent = new Student();

        //add Student to the model
        themodel.addAttribute("student", theStudent);

        //add the country options to the model
        themodel.addAttribute("countries", countries);

        themodel.addAttribute("favoriteLanguages", favoriteLanguages);


        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        //log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName() + " " + theStudent.getCountry());

        return "student-confirmation";
    }
}
