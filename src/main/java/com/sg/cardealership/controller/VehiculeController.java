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
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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

    @RequestMapping(value = {"/","/index","/home","/home/index"}, method = RequestMethod.GET)
    public String displayIndexPage(Model model) {

        List<Vehicule> vehicules = vehiculeRepository.findByFeatured(true);
        
        model.addAttribute("vehicules", vehicules);
        return carDealershipView.displayIndexPage();
    }
    
    @GetMapping("/inventory/new")
    public String displayNewInventory(Model model) {

        List<Vehicule> vehicules = vehiculeRepository.findByType("New");
        
        model.addAttribute("type", "New");
        model.addAttribute("vehicules", vehicules);
        model.addAttribute("activePage", "newInventory");
        
        return carDealershipView.displayInventoryPage();
    }

    
    @GetMapping("/inventory/used")
    public String displayUsedInventory(Model model) {

        List<Vehicule> vehicules = vehiculeRepository.findByType("Used");
        
        model.addAttribute("type", "Used");
        model.addAttribute("vehicules", vehicules);
        model.addAttribute("activePage", "usedInventory");
        
        return carDealershipView.displayInventoryPage();
    }
    
    @GetMapping("/home/specials")
    public String displaySpecials(Model model) {

        List<Special> specials = specialRepository.findAll();
        
        model.addAttribute("specials", specials);
        model.addAttribute("activePage", "specials");
        
        return carDealershipView.displaySpecialPage();
    }

    @GetMapping("/home/contact")
    public String displaContact(Model model) {

        List<Special> specials = specialRepository.findAll();
        
        model.addAttribute("specials", specials);
        model.addAttribute("activePage", "contact");
        
        return carDealershipView.displayContactPage();
    }
    
    
    //Display details of a specific superhuman by id
    @GetMapping("/inventory/details")
    public String displayDetailedVehicule(Integer id, Model model) {
        Vehicule vehicule = vehiculeRepository.findById(id).orElse(null);
        model.addAttribute("vehicule", vehicule);
        return carDealershipView.displayVehiculeDetailsPage();
    }
}
