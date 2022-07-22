/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package com.sg.cardealership.repository;

import com.sg.cardealership.entity.User;
import com.sg.cardealership.entity.Vehicule;
import com.sg.cardealership.view.CarDealershipView;
import java.util.List;
import javax.sql.DataSource;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class VehiculeRepositoryTest {
    
//    @Autowired
//    VehiculeRepository vehiculeRepository;
//    
//    @Autowired
//    CarDealershipView carDealershipView;
//    
//    @Autowired
//    ContactRepository contactRepository;
//    
//    @Autowired
//    MakeRepository makeRepository;
//    
//    @Autowired
//    CarModelRepository carModelRepository;
//    
//    @Autowired
//    SaleRepository saleRepository;
//    
//    @Autowired
//    SpecialRepository specialRepository;
//    
//    @Autowired
//    UserRepository userRepository;

    
     @Autowired 
     private VehiculeRepository vehiculeRepository;
     
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
    }
    
    @AfterEach
    public void tearDown() {
        
    }
        @Test
    public void testAddVehicule(){

        //given - precondition or setup
        Vehicule vehicule = new Vehicule();
        vehicule.setDescription("");
        // when - action or the behaviour that we are going test
        Vehicule savedvehicule = vehiculeRepository.save(vehicule);

        // then - verify the output
        assertThat(savedvehicule).isNotNull();
        assertThat(savedvehicule.getVehiculeId()).isGreaterThan(0);
    }
    
    @Test
    public void testAddAndGetVehicule(){

        //given - precondition or setup
        Vehicule vehicule = new Vehicule();
        vehicule.setDescription("test");
        // when - action or the behaviour that we are going test
        vehiculeRepository.save(vehicule);
        Vehicule fromRepo = vehiculeRepository.findById(vehicule.getVehiculeId()).orElse(null);
        // then - verify the output
        assertEquals(vehicule,fromRepo);
        assertEquals(vehicule.getDescription(),fromRepo.getDescription() );
    }
    
    @Test
    public void testAddAndDelete(){
        //given - precondition or setup
        Vehicule vehicule = new Vehicule();
        vehicule.setDescription("test");
        vehiculeRepository.save(vehicule);
        Vehicule fromRepo1 = vehiculeRepository.findById(vehicule.getVehiculeId()).orElse(null);
        assertEquals(vehicule,fromRepo1);
        
        // when - action or the behaviour that we are going test
        vehiculeRepository.delete(vehicule);
        Vehicule fromRepo2 = vehiculeRepository.findById(vehicule.getVehiculeId()).orElse(null);
        
         // then - verify the output
        Assertions.assertNull(fromRepo2);
    }
    
}
    

