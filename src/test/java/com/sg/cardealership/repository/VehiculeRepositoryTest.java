/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package com.sg.cardealership.repository;

import com.sg.cardealership.entity.CarModel;
import com.sg.cardealership.entity.User;
import com.sg.cardealership.entity.Vehicule;
import com.sg.cardealership.view.CarDealershipView;
import java.time.LocalDate;
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

    @Autowired 
    VehiculeRepository vehiculeRepository;
     
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

        Vehicule vehicule = new Vehicule();
        vehicule.setDescription("");
        Vehicule savedvehicule = vehiculeRepository.save(vehicule);

        assertThat(savedvehicule).isNotNull();
        assertThat(savedvehicule.getVehiculeId()).isGreaterThan(0);
    }
    
    @Test
    public void testAddAndGetVehicule(){

        Vehicule vehicule = new Vehicule();
        vehicule.setDescription("test");
        
        CarModel carModel = new CarModel(0, null, "A8", LocalDate.now(), null);
        carModelRepository.save(carModel);
        
        vehicule.setCarModel(carModel);
        vehiculeRepository.save(vehicule);
        Vehicule fromRepo = vehiculeRepository.findById(vehicule.getVehiculeId()).orElse(null);
        assertEquals(vehicule,fromRepo);
        assertEquals(vehicule.getDescription(),fromRepo.getDescription() );
    }
    
    @Test
    public void testAddAndDelete(){
        Vehicule vehicule = new Vehicule();
        vehicule.setDescription("test");
        vehiculeRepository.save(vehicule);
        Vehicule fromRepoBeforeDelete = vehiculeRepository.findById(vehicule.getVehiculeId()).orElse(null);
        assertEquals(vehicule,fromRepoBeforeDelete);
        
        vehiculeRepository.delete(vehicule);
        Vehicule fromRepoAfterDelete = vehiculeRepository.findById(vehicule.getVehiculeId()).orElse(null);
        
        Assertions.assertNull(fromRepoAfterDelete);
    }
    
    @Test
    public void testAddAndUpdate(){
        Vehicule vehicule = new Vehicule();
        vehicule.setDescription("before");
        vehiculeRepository.save(vehicule);
        Vehicule fromRepoBeforeUpdate = vehiculeRepository.findById(vehicule.getVehiculeId()).orElse(null);
        assertEquals(vehicule,fromRepoBeforeUpdate);
        
        
        fromRepoBeforeUpdate.setDescription("after");
        vehiculeRepository.save(fromRepoBeforeUpdate);
        Vehicule fromRepoAfterDelete = vehiculeRepository.findById(vehicule.getVehiculeId()).orElse(null);
        
        assertEquals("after", fromRepoAfterDelete.getDescription());
    }
    
}
