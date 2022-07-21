/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.controller;

import com.sg.cardealership.entity.CarModel;
import com.sg.cardealership.entity.Contact;
import com.sg.cardealership.entity.Make;
import com.sg.cardealership.entity.Sale;
import com.sg.cardealership.entity.Special;
import com.sg.cardealership.entity.User;
import com.sg.cardealership.entity.Vehicule;
import com.sg.cardealership.repository.ContactRepository;
import com.sg.cardealership.repository.MakeRepository;
import com.sg.cardealership.repository.SaleRepository;
import com.sg.cardealership.repository.SpecialRepository;
import com.sg.cardealership.repository.UserRepository;
import com.sg.cardealership.repository.VehiculeRepository;
import com.sg.cardealership.view.CarDealershipView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sg.cardealership.repository.CarModelRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class CarDealershipRestController {
    
    @Autowired
    VehiculeRepository vehiculeRepository;
    
    @Autowired
    CarDealershipView carDealershipView;
    
    @Autowired
    ContactRepository contactRepository;
    
    @Autowired
    MakeRepository makeRepository;
    
    @Autowired
    CarModelRepository carModelRepository;
    
    @Autowired
    SaleRepository saleRepository;
    
    @Autowired
    SpecialRepository specialRepository;
    
    @Autowired
    UserRepository userRepository;
    
    Set<ConstraintViolation<Vehicule>> vehiculeViolations = new HashSet<>();

    @GetMapping("/specials")
    public List<Special> getSpecials() {
       
        return specialRepository.findAll();
        
    }

}
