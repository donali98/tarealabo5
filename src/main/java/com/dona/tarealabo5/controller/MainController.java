package com.dona.tarealabo5.controller;

import java.util.List;

import javax.validation.Valid;

import com.dona.tarealabo5.dao.StudentDAO;
import com.dona.tarealabo5.domain.Estudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/inicio")
    public ModelAndView newStudent() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("student", new Estudiante());
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/listado")
    public ModelAndView listStudents() {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> students = null;
        try {
            students = studentDAO.findAll();
        }
        catch(Exception e) {
            e.printStackTrace();
        }


        mav.addObject("students", students);
        mav.setViewName("list");

        return mav;
    }
    @RequestMapping(value="/insert")    
    public ModelAndView saveStudent(@Valid @ModelAttribute Estudiante student, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
            mav.setViewName("index");
            mav.addObject("student", student);
        }
        else {
            studentDAO.save(student);
            mav.setViewName("index");
            mav.addObject("student", new Estudiante());
        }
        return mav;
    }
}