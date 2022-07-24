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
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/models")
    public List<CarModel> getModels(Integer makeId) {
       Make make = makeRepository.findById(makeId).orElse(null);
        return carModelRepository.findByMake(make);
        
    }
    @GetMapping("/specials")
    public List<Special> getSpecials() {
       
        return specialRepository.findAll();
        
    }
    
    @GetMapping("/newInventory")
    public List<Vehicule> getNewInventory() {
       
        return vehiculeRepository.findByType("New");
        
    }
    @GetMapping("/usedInventory")
    public List<Vehicule> getUsedInventory() {
       
        return vehiculeRepository.findByType("Used");
        
    }

    @DeleteMapping("/admin/deleteVehicule/{id}")
    public void deleteVehicule(@PathVariable int id) {
        vehiculeRepository.deleteById(id);
    }
    
    @GetMapping("/inventory")
    public List<Vehicule> displaySearchVehicule(String type,String quickSearch, Integer minPrice, Integer maxPrice, Integer minYear,Integer maxYear) {
        
        quickSearch = (quickSearch != null) ? '%'+quickSearch+'%' : "%%";
        minPrice = (minPrice != null) ? minPrice : 0;
        maxPrice = (maxPrice != null) ? maxPrice : vehiculeRepository.findMaxPrice();
        minYear = (minYear != null) ? minYear : 0;
        maxYear = (maxYear != null) ? maxYear : vehiculeRepository.findMaxYear();
       
        return queryHelper(type, quickSearch, minPrice,maxPrice,minYear,maxYear);

    }
    
    
    @GetMapping("/availableInventory")
    public List<Vehicule> searchAvailableVehicule(String quickSearch, Integer minPrice, Integer maxPrice, Integer minYear,Integer maxYear) {
        
        quickSearch = (quickSearch != null) ? '%'+quickSearch+'%' : "%%";
        minPrice = (minPrice != null) ? minPrice : 0;
        maxPrice = (maxPrice != null) ? maxPrice : vehiculeRepository.findMaxPrice();
        minYear = (minYear != null) ? minYear : 0;
        maxYear = (maxYear != null) ? maxYear : vehiculeRepository.findMaxYear();
       
        return queryHelper(quickSearch, minPrice,maxPrice,minYear,maxYear);

    }
    
    public List<Vehicule> queryHelper(String quickSearch,int minPrice,int maxPrice,int minYear,int maxYear){
        return vehiculeRepository.findBySearchForSales(quickSearch, quickSearch, quickSearch, minPrice, maxPrice,minYear, maxYear);
    }
    
    public List<Vehicule> queryHelper(String type, String quickSearch,int minPrice,int maxPrice,int minYear,int maxYear){
        return vehiculeRepository.findBySearch(type, quickSearch, quickSearch, quickSearch, minPrice, maxPrice,minYear, maxYear);
    }
}
