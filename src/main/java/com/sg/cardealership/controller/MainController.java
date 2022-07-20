/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.controller;

import com.sg.cardealership.dao.CarDao;
import com.sg.cardealership.dao.MakeDao;
import com.sg.cardealership.dao.ModelDao;
import com.sg.cardealership.dao.VehiculeDao;
import com.sg.cardealership.entity.Car;
import com.sg.cardealership.entity.Vehicule;
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
    VehiculeDao vehiculeDao;
    @Autowired
    ModelDao modelDao;
    @Autowired
    MakeDao makeDao;
    
    @Autowired
    CarDealershipView carDealershipView;
    
    Set<ConstraintViolation<Car>> vehiculeViolations = new HashSet<>();

    
    @GetMapping("index")
    public String displayIndexPage(Model model) {
        List<Vehicule> vehicules = vehiculeDao.getFeaturedVehicules();
        for(Vehicule v : vehicules){
//            Make make = makeDao.
        }
        model.addAttribute("vehicules", vehicules);
        model.addAttribute("errors", vehiculeViolations);
        
        return carDealershipView.displayIndexPage();
    }
    
    //map the home to the index page
    @GetMapping("/")
    public String displayHomePage(Model model) {
        return displayIndexPage(model);
    }
}
