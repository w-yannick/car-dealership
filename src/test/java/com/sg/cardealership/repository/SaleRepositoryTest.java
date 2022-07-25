/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package com.sg.cardealership.repository;

import com.sg.cardealership.entity.CarModel;
import com.sg.cardealership.entity.Sale;
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

public class SaleRepositoryTest {

    
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
     
    public SaleRepositoryTest() {
        
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
    public void testAddSale(){

        Sale sale = new Sale();
        sale.setName("Bob");
        
        
        saleRepository.save(sale);

        assertThat(sale).isNotNull();
        assertThat(sale.getSaleId()).isGreaterThan(0);
    }
    
    @Test
    public void testAddAndGetSale(){

        Sale sale = new Sale();
        sale.setName("Bob");
        saleRepository.save(sale);
        
        Sale fromRepo = saleRepository.findById(sale.getSaleId()).orElse(null);
        assertEquals(sale,fromRepo);
        assertEquals("Bob",fromRepo.getName());
    }
    
    @Test
    public void testAddAndDelete(){
        Sale sale = new Sale();
        sale.setName("Bob");
        saleRepository.save(sale);
        
        Sale fromRepoBeforeDelete = saleRepository.findById(sale.getSaleId()).orElse(null);
        assertEquals(sale,fromRepoBeforeDelete);
        
        saleRepository.delete(sale);
        Sale fromRepoAfterDelete = saleRepository.findById(sale.getSaleId()).orElse(null);
        
        Assertions.assertNull(fromRepoAfterDelete);
    }
    
    @Test
    public void testAddAndUpdate(){
        Sale sale = new Sale();
        sale.setName("Bob");
        saleRepository.save(sale);
        
        Sale fromRepoBeforeUpdate = saleRepository.findById(sale.getSaleId()).orElse(null);
        assertEquals(sale,fromRepoBeforeUpdate);
        
        
        fromRepoBeforeUpdate.setName("Sponge");
        saleRepository.save(fromRepoBeforeUpdate);
        Sale fromRepoAfterDelete = saleRepository.findById(sale.getSaleId()).orElse(null);
        
        assertEquals("Sponge", fromRepoAfterDelete.getName());
    }
    
}
