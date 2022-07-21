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


@Controller
public class VehiculeController {
    
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

    @GetMapping("index")
    public String displayIndexPage(Model model) {
        List<Contact> contacts = contactRepository.findAll();
        List<Make> makes = makeRepository.findAll();
        List<CarModel> carModels = carModelRepository.findAll();
        List<Sale> sales = saleRepository.findAll();
        List<Special> specials = specialRepository.findAll();
        List<User> users = userRepository.findAll();

//        List<Vehicule> vehicules = vehiculeRepository.findAll();
        List<Vehicule> vehicules = vehiculeRepository.findByFeatured(true);
        
        model.addAttribute("vehicules", vehicules);
        model.addAttribute("specials", specials);
        return carDealershipView.displayIndexPage();
    }
    
    //map the home to the index page
    @GetMapping("/")
    public String displayHomePage(Model model) {
        return displayIndexPage(model);
    }
}
