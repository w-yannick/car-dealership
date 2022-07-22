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
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RetailController {
    
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
    Set<ConstraintViolation<Contact>> contactViolations = new HashSet<>();

    @RequestMapping(value = {"/","/index","/home","/home/index"}, method = RequestMethod.GET)
    public String displayIndexPage(Model model) {

        List<Vehicule> vehicules = vehiculeRepository.findByFeatured(true);
//        List<Vehicule> vehicules = vehiculeRepository.findAll();
//        List<Vehicule> vehicules = vehiculeRepository.findByPriceAndYear("Used",0,999999,0,9999);
//        carModelRepository.deleteById(1);
        model.addAttribute("vehicules", vehicules);
        model.addAttribute("errors", vehiculeViolations);
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

        model.addAttribute("activePage", "contact");
        model.addAttribute("errors", contactViolations);
        
        return carDealershipView.displayContactPage();
    }
    
    @PostMapping("/home/contact/add")
    public String addContact(String name, String email, String phone, String message) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setMessage(message);
        
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        contactViolations = validate.validate(contact);
        
        if(contactViolations.isEmpty()) {
            contactRepository.save(contact);
        }
        
        return "redirect:/home/contact";
    }
    
    
    
    @GetMapping("/inventory/details")
    public String displayDetailedVehicule(Integer id, Model model) {
        Vehicule vehicule = vehiculeRepository.findById(id).orElse(null);
        model.addAttribute("vehicule", vehicule);
        
        return carDealershipView.displayVehiculeDetailsPage();
    }
    
    @GetMapping("/login")
    public String displayLogin(Model model) {
        
        
        model.addAttribute("activePage", "login");

        return carDealershipView.displayLoginPage();
    }
}
