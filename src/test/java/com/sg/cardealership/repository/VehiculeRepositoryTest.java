/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package com.sg.cardealership.repository;

import com.sg.cardealership.entity.Vehicule;
import com.sg.cardealership.view.CarDealershipView;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class VehiculeRepositoryTest {
    
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


    public VehiculeRepositoryTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach 
    public void setUp() {
        
        //TODO CLEAN DB BEFORE TESTS
//        List<Vehicule> vehicules = this.vehiculeRepository.findAll();
//        vehicules.forEach(v -> {
//            vehiculeRepository.deleteById(v.getVehiculeId());
//        });
        
    }
    
    @AfterEach
    public void tearDown() {
        
    }
    
    @Test
    public void testfindByFeatured(){
        
        //TODO: REMOVE ALL THEN ADD THEN RETEST
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        Assertions.assertEquals(11,vehicules.size());
    }
    
    @Test
    public void dummyTest2(){
        
        //TODO: ADD TO DB BEFORE TEST, RIGHT NOW THE DB TEST HAVE 2 VEHICULES WITH FEATURED SET TO TRUE
        List<Vehicule> vehicules = vehiculeRepository.findByFeatured(true);
        Assertions.assertEquals(10,vehicules.size());
    }
}
    

