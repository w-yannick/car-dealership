/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.controller;

import com.sg.cardealership.dao.CarDao;
import com.sg.cardealership.entity.Car;
import com.sg.cardealership.view.CarDealershipView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author w-yan
 */
@Controller
public class MainController {
    
    @Autowired
    CarDao carDao;
    
    @Autowired
    CarDealershipView carDealershipView;
    
    Set<ConstraintViolation<Car>> carViolations = new HashSet<>();

    
    @GetMapping("index")
    public String displayIndexPage(Model model) {
        List<Car> cars = carDao.getAllCars();
        model.addAttribute("cars", cars);
        model.addAttribute("errors", carViolations);
        
        return carDealershipView.displayIndexPage();
    }
    
    //map the home to the index page
    @GetMapping("/")
    public String displayHomePage(Model model) {
        return displayIndexPage(model);
    }
}
